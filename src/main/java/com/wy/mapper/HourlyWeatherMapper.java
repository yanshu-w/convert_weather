package com.wy.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wy.domain.entity.HourlyWeather;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface HourlyWeatherMapper extends BaseMapper<HourlyWeather> {
}
