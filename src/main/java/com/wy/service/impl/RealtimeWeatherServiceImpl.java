package com.wy.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wy.domain.entity.RealtimeWeather;
import com.wy.mapper.RealtimeWeatherMapper;
import com.wy.service.IRealtimeWeatherService;
import org.springframework.stereotype.Service;

@Service
public class RealtimeWeatherServiceImpl extends ServiceImpl<RealtimeWeatherMapper, RealtimeWeather> implements IRealtimeWeatherService {
}
