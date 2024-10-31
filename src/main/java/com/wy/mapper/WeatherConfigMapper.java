package com.wy.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wy.domain.entity.WeatherConfig;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface WeatherConfigMapper extends BaseMapper<WeatherConfig> {
}
