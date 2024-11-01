package com.wy.server;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.map.MapUtil;
import cn.hutool.http.HttpUtil;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.wy.common.constant.CaiYunApiType;
import com.wy.convert.ResultConvert;
import com.wy.convert.impl.RealtimeConvert;
import com.wy.domain.entity.RealtimeWeather;
import com.wy.domain.entity.WeatherConfig;
import com.wy.domain.vo.MqttParam;
import com.wy.service.IApiConfigService;
import com.wy.service.IRealtimeWeatherService;
import com.wy.service.IWeatherConfigService;
import com.wy.utils.JsonUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.util.JavaScriptUtils;

import java.util.*;


//@Component
@Slf4j
@RequiredArgsConstructor
public class WeatherServerOld {

    @Value("${caiyun.url}")
    private String url;

    @Value("${caiyun.token}")
    private String token;

    @Value("${caiyun.version}")
    private String version;

    private final IApiConfigService apiConfigService;

    private final IWeatherConfigService weatherConfigService;

    private final IRealtimeWeatherService realtimeWeatherService;


    @Transactional
    public String getWeather(MqttParam mqttParam) {
        Map<String, Object> result = new HashMap<>();

        //校验mqtt的token
        boolean bole = apiConfigService.checkToken(mqttParam.getToken());

        if (!bole) {
            result.put("status", "error");
            result.put("msg", "请求次数已经耗尽，请联系管理员");
            return JsonUtil.objectToJson(result);
        }

        //先去查询是否存在2分钟之内的数据如果有则返回哪个数据
        String nearWeather = weatherConfigService.getNearWeather(mqttParam);

        if (StringUtils.isNotBlank(nearWeather)) {
            return nearWeather;
        }

        String apiUrl = url + "/" + version + "/" + token + "/" + mqttParam.getLon() + "," + mqttParam.getLat() +
                "/realtime";

        String urlBody = HttpUtil.get(apiUrl);

        if (StringUtils.isBlank(urlBody)) {
            result.put("status", "error");
            result.put("msg", "获取天气失败，请联系管理员");
            return JsonUtil.objectToJson(result);
        }

        Map<String, Object> map = JsonUtil.JsonToMap(urlBody, String.class, Object.class);

        if (!Objects.equals(map.get("status"), "ok")) {
            result.put("status", "error");
            result.put("msg", "获取天气失败，请联系管理员");
            return JsonUtil.objectToJson(result);
        }

        apiConfigService.minusTime(mqttParam.getToken());

        LinkedHashMap mapOfResult = (LinkedHashMap) map.get("result");
        map.remove("result");

        String json = null;

        //最外层的信息
        WeatherConfig weatherConfig = BeanUtil.toBean(map, WeatherConfig.class);
        weatherConfig.setType(mqttParam.getType());
        //Map<String, Object> weatherMap = BeanUtil.beanToMap(weatherConfig);
        weatherConfig.setCreateTime(new Date());
        Map<String, Object> resultMap = null;
        Long resultId = -1L;

        //每个类型的信息  最后在汇总到最外层
        if (Objects.equals(mqttParam.getType(), CaiYunApiType.TYPE_REALTIME)) {
            RealtimeWeather realtimeWeather = new RealtimeConvert().doConvert(JsonUtil.objectToJson(mapOfResult.get(
                    "realtime")));
            realtimeWeatherService.save(realtimeWeather);
            resultId = realtimeWeather.getId();
            resultMap = BeanUtil.beanToMap(realtimeWeather);
        }

        map.putAll(resultMap);
        weatherConfig.setResultId(resultId);
        weatherConfigService.save(weatherConfig);

        json = JsonUtil.objectToJson(map);

        return json;
    }

}
