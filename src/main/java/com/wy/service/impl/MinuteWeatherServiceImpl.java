package com.wy.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wy.domain.entity.MinuteWeather;
import com.wy.mapper.MinuteWeatherMapper;
import com.wy.service.IMinuteWeatherService;
import org.springframework.stereotype.Service;

@Service
public class MinuteWeatherServiceImpl extends ServiceImpl<MinuteWeatherMapper, MinuteWeather> implements IMinuteWeatherService {
}
