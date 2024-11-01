package com.wy.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wy.domain.entity.WeatherConfig;
import com.wy.domain.vo.MqttParam;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface WeatherConfigMapper extends BaseMapper<WeatherConfig> {

    /**
     * 获取两分钟之内的天气配置
     */
    WeatherConfig getNearFuture(@Param("param") MqttParam mqttParam);

}
