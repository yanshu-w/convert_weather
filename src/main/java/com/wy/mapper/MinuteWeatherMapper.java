package com.wy.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wy.domain.entity.MinuteWeather;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MinuteWeatherMapper extends BaseMapper<MinuteWeather> {
}