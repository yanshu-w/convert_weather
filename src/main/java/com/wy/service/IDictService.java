package com.wy.service;

import com.wy.domain.dict.*;

import java.util.List;
import java.util.Map;

public interface IDictService {
    Map<Long,String> loadAirPollutionDict();

    Map<Long,String> loadCarWashingDict();

    Map<Long,String> loadColdRiskDict();

    Map<Long,String> loadComfortDict();

    Map<Long,String> loadDressingDict();

    Map<Integer,String> loadHttpStatusCodeDict();

    List<PrecipitationConditionDict> loadPrecipitationConditionDict();

    Map<Long,String> loadUltravioletDailyDict();

    Map<Long,String> loadUltravioletRealtimeDict();

    Map<String,WeatherConditionDict> loadWeatherConditionDict();

    List<WindDirectionDict> loadWindDirectionDict();

    List<WindLevelDict> loadWindLevelDict();
}
