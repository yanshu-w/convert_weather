package com.wy.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wy.domain.entity.WeatherAlert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface WeatherAlertMapper extends BaseMapper<WeatherAlert> {
}