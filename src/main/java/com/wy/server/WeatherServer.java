package com.wy.server;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.http.HttpUtil;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.wy.common.constant.CaiYunApiType;
import com.wy.convert.impl.DailyConvert;
import com.wy.convert.impl.HourlyConvert;
import com.wy.convert.impl.MinutelyConvert;
import com.wy.convert.impl.RealtimeConvert;
import com.wy.domain.entity.*;
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

    private static final Map<Integer, String> WEATHER_TYPE = new HashMap<>() {{
        put(1, "realtime");
        put(2, "minutely");
        put(3, "hourly?hourlysteps={hourlysteps}");
        put(4, "daily?dailysteps={dailysteps}");
    }};


    public List<String> getWeather(MqttParam mqttParam) {
        Map<String, Object> result = new HashMap<>();

        List<String> resultList = new ArrayList<>();

        //校验mqtt的token；获取次数
        Integer apiTime = apiConfigService.checkToken(mqttParam.getToken());

        if (Objects.isNull(apiTime) || Objects.equals(apiTime, 0)) {
            result.put("status", "error");
            result.put("msg", Content.GET_API_TIME_ERROR);
            return List.of(Objects.requireNonNull(JsonUtil.objectToJson(result)));
        }

        String apiUrl =
                StrUtil.format(url + "/" + version + "/" + token + "/" + mqttParam.getLon() + "," + mqttParam.getLat() + "/" + WEATHER_TYPE.get(mqttParam.getType()), new HashMap<String, Integer>() {{
                    put("hourlysteps", mqttParam.getHourlySteps());
                    put("dailysteps", mqttParam.getDailySteps());
                }});

        String urlBody = HttpUtil.get(apiUrl);

        if (StringUtils.isBlank(urlBody)) {
            return returnError(Content.GET_API_ERROR);
        }

        Map<String, Object> map = JsonUtil.JsonToMap(urlBody, String.class, Object.class);

        if (CollUtil.isEmpty(map)) {
            return returnError(Content.GET_API_ERROR);
        }

        if (!Objects.equals(map.get("status"), "ok")) {
            return returnError(Content.GET_API_ERROR);
        }

        //签名次数减一
        apiConfigService.minusTime(mqttParam.getToken());

        LinkedHashMap mapOfResult = (LinkedHashMap) map.get("result");
        map.remove("result");
        map.put("api_time", apiTime - 1);

        //每个类型的信息  最后在汇总到最外层
        if (Objects.equals(mqttParam.getType(), CaiYunApiType.TYPE_REALTIME.getCode())) {

            RealtimeWeather realtimeWeather =
                    new RealtimeConvert().doConvert(JsonUtil.objectToJson(mapOfResult.get(CaiYunApiType.TYPE_REALTIME.getResultName())));
            map.putAll(BeanUtil.beanToMap(realtimeWeather));
            resultList.add(JsonUtil.objectToJson(map));

        } else if (Objects.equals(mqttParam.getType(), CaiYunApiType.TYPE_MINUTELY.getCode())) {

            MinutelyWeather minutelyWeather =
                    new MinutelyConvert().doConvert(JsonUtil.objectToJson(mapOfResult.get(CaiYunApiType.TYPE_MINUTELY.getResultName())));
            map.putAll(BeanUtil.beanToMap(minutelyWeather));
            resultList.add(JsonUtil.objectToJson(map));

        } else if (Objects.equals(mqttParam.getType(), CaiYunApiType.TYPE_HOURLY.getCode())) {

            List<HourlyWeather> hourly =
                    new HourlyConvert().doConvert(JsonUtil.objectToJson(mapOfResult.get(CaiYunApiType.TYPE_HOURLY.getResultName())));
            for (HourlyWeather hourlyWeather : hourly) {
                map.putAll(BeanUtil.beanToMap(hourlyWeather));
                resultList.add(JsonUtil.objectToJson(map));
            }

        } else if (Objects.equals(mqttParam.getType(), CaiYunApiType.TYPE_DAILY.getCode())) {
            List<DailyWeather> daily =
                    new DailyConvert().doConvert(JsonUtil.objectToJson(mapOfResult.get(CaiYunApiType.TYPE_DAILY.getResultName())));
            for (DailyWeather dailyWeather : daily) {
                map.putAll(BeanUtil.beanToMap(dailyWeather));
                resultList.add(JsonUtil.objectToJson(map));
            }
        }

        return resultList;
    }


    private List<String> returnError(String msg) {
        Map<String, Object> result = new HashMap<>();
        result.put("status", "error");
        result.put("msg", msg);
        return List.of(Objects.requireNonNull(JsonUtil.objectToJson(result)));
    }

    static class Content {
        public static final String GET_API_ERROR = "获取天气失败，请联系管理员";
        public static final String GET_API_TIME_ERROR = "请求次数已经耗尽，请联系管理员";
    }

}
