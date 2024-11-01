package com.wy.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wy.domain.entity.WeatherConfig;
import com.wy.domain.vo.MqttParam;

public interface IWeatherConfigService extends IService<WeatherConfig> {

    /**
     * 获取附近天气情况
     * @return JSON
     */
    String getNearWeather(MqttParam mqttParam);

}
