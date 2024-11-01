package com.wy.server;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.http.HttpUtil;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.wy.common.constant.CaiYunApiType;
import com.wy.convert.impl.RealtimeConvert;
import com.wy.domain.entity.RealtimeWeather;
import com.wy.domain.entity.WeatherConfig;
import com.wy.domain.vo.MqttParam;
import com.wy.service.IApiConfigService;
import com.wy.utils.JsonUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;


@Component
@Slf4j
@RequiredArgsConstructor
public class WeatherServer {

    @Value("${caiyun.url}")
    private String url;

    @Value("${caiyun.token}")
    private String token;

    @Value("${caiyun.version}")
    private String version;

    private final IApiConfigService apiConfigService;

    @Transactional
    public List<String> getWeather(MqttParam mqttParam) {
        Map<String, Object> result = new HashMap<>();

        List<String> resultList = new ArrayList<>();


        //校验mqtt的token
        boolean bole = apiConfigService.checkToken(mqttParam.getToken());

        if (!bole) {
            result.put("status", "error");
            result.put("msg", "请求次数已经耗尽，请联系管理员");
            return List.of(Objects.requireNonNull(JsonUtil.objectToJson(result)));
        }

        String apiUrl = url + "/" + version + "/" + token + "/" + mqttParam.getLon() + "," + mqttParam.getLat() +
                "/realtime";

        String urlBody = HttpUtil.get(apiUrl);

        if (StringUtils.isBlank(urlBody)) {
            result.put("status", "error");
            result.put("msg", "获取天气失败，请联系管理员");
            return List.of(Objects.requireNonNull(JsonUtil.objectToJson(result)));
        }

        Map<String, Object> map = JsonUtil.JsonToMap(urlBody, String.class, Object.class);

        if (!Objects.equals(map.get("status"), "ok")) {
            result.put("status", "error");
            result.put("msg", "获取天气失败，请联系管理员");
            return List.of(Objects.requireNonNull(JsonUtil.objectToJson(result)));
        }

        //签名次数减一
        apiConfigService.minusTime(mqttParam.getToken());

        LinkedHashMap mapOfResult = (LinkedHashMap) map.get("result");
        map.remove("result");


        //最外层的信息
        WeatherConfig weatherConfig = BeanUtil.toBean(map, WeatherConfig.class);
        weatherConfig.setType(mqttParam.getType());
        weatherConfig.setCreateTime(new Date());

        //每个类型的信息  最后在汇总到最外层
        if (Objects.equals(mqttParam.getType(), CaiYunApiType.TYPE_REALTIME)) {
            RealtimeWeather realtimeWeather = new RealtimeConvert().doConvert(JsonUtil.objectToJson(mapOfResult.get(
                    "realtime")));
            Map<String, Object> beanToMap = BeanUtil.beanToMap(realtimeWeather);
            map.putAll(beanToMap);
            resultList.add(JsonUtil.objectToJson(map));
        }

        return resultList;
    }

}
