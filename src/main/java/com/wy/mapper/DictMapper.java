package com.wy.mapper;

import com.wy.domain.dict.*;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface DictMapper {

    List<AirPollutionDict> getAirPollutionDict();

    List<CarWashingDict> getCarWashingDict();

    List<ColdRiskDict> getColdRiskDict();

    List<ComfortDict> getComfortDict();

    List<DressingDict> getDressingDict();

    List<HttpStatusCodeDict> getHttpStatusCodeDict();

    List<PrecipitationConditionDict> getPrecipitationConditionDict();

    List<UltravioletDailyDict> getUltravioletDailyDict();

    List<UltravioletRealtimeDict> getUltravioletRealtimeDict();

    List<WeatherConditionDict> getWeatherConditionDict();

    List<WindDirectionDict> getWindDirectionDict();

    List<WindLevelDict> getWindLevelDict();

}
