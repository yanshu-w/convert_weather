package com.wy.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wy.domain.entity.HourlyWeather;
import com.wy.mapper.HourlyWeatherMapper;
import com.wy.service.IHourlyWeatherService;
import org.springframework.stereotype.Service;

@Service
public class HourlyWeatherServiceImpl extends ServiceImpl<HourlyWeatherMapper, HourlyWeather> implements IHourlyWeatherService {
}
