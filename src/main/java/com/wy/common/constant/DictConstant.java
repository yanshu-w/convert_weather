package com.wy.common.constant;

import com.wy.domain.dict.WeatherConditionDict;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class DictConstant {


    public static class Skycon {

        private static Map<String, WeatherConditionDict> WEATHER_CONDITION_DICT_MAP = new HashMap<>();

        public static void init(Map<String, WeatherConditionDict> dictMap) {
            WEATHER_CONDITION_DICT_MAP = dictMap;
        }

        public static String getName(String key) {
            WeatherConditionDict weatherConditionDict = WEATHER_CONDITION_DICT_MAP.get(key);
            if (Objects.isNull(weatherConditionDict)) {
                return key;
            }
            return weatherConditionDict.getConditionName();
        }
    }

}
