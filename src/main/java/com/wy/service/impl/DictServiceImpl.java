package com.wy.service.impl;

import com.wy.domain.dict.*;
import com.wy.mapper.DictMapper;
import com.wy.service.IDictService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class DictServiceImpl implements IDictService {

    @Resource
    private DictMapper dictMapper;


    @Override
    public Map<Long, String> loadAirPollutionDict() {
        List<AirPollutionDict> airPollutionDict = dictMapper.getAirPollutionDict();
        return null;
    }

    @Override
    public Map<Long, String> loadCarWashingDict() {
        return null;
    }

    @Override
    public Map<Long, String> loadColdRiskDict() {
        return null;
    }

    @Override
    public Map<Long, String> loadComfortDict() {
        return null;
    }

    @Override
    public Map<Long, String> loadDressingDict() {
        return null;
    }

    @Override
    public Map<Integer, String> loadHttpStatusCodeDict() {
        return null;
    }

    @Override
    public List<PrecipitationConditionDict> loadPrecipitationConditionDict() {
        return null;
    }

    @Override
    public Map<Long, String> loadUltravioletDailyDict() {
        return null;
    }

    @Override
    public Map<Long, String> loadUltravioletRealtimeDict() {
        return null;
    }

    @Override
    public Map<String, WeatherConditionDict> loadWeatherConditionDict() {
        List<WeatherConditionDict> weatherConditionDict = dictMapper.getWeatherConditionDict();
        return weatherConditionDict.stream().collect(Collectors.toMap(WeatherConditionDict::getConditionCode, v -> v,
                (m1, m2) -> m2));

    }

    @Override
    public List<WindDirectionDict> loadWindDirectionDict() {
        return null;
    }

    @Override
    public List<WindLevelDict> loadWindLevelDict() {
        return null;
    }
}
