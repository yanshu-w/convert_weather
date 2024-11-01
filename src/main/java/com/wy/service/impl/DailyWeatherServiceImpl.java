package com.wy.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wy.domain.entity.DailyWeather;
import com.wy.mapper.DailyWeatherMapper;
import com.wy.service.IDailyWeatherService;
import org.springframework.stereotype.Service;

@Service
public class DailyWeatherServiceImpl extends ServiceImpl<DailyWeatherMapper, DailyWeather> implements IDailyWeatherService {
}
