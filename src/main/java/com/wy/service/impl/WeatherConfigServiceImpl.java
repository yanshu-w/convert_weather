package com.wy.service.impl;


import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wy.common.constant.CaiYunApiType;
import com.wy.domain.entity.RealtimeWeather;
import com.wy.domain.entity.WeatherConfig;
import com.wy.domain.vo.MqttParam;
import com.wy.mapper.WeatherConfigMapper;
import com.wy.service.IRealtimeWeatherService;
import com.wy.service.IWeatherConfigService;
import com.wy.utils.JsonUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Map;
import java.util.Objects;

@Service
public class WeatherConfigServiceImpl extends ServiceImpl<WeatherConfigMapper, WeatherConfig> implements IWeatherConfigService {

    @Resource
    private IRealtimeWeatherService realtimeWeatherService;

    @Override
    public String getNearWeather(MqttParam mqttParam) {
        WeatherConfig nearFuture = baseMapper.getNearFuture(mqttParam);
        Map<String, Object> weatherMap = BeanUtil.beanToMap(nearFuture);

        if (Objects.isNull(nearFuture)) {
            return null;
        }

        if (Objects.equals(mqttParam.getType(), CaiYunApiType.TYPE_REALTIME)) {
            RealtimeWeather byId = realtimeWeatherService.getById(nearFuture.getResultId());
            weatherMap.putAll(BeanUtil.beanToMap(byId));
        }

        return JsonUtil.objectToJson(weatherMap);

    }
}
