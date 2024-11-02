package com.wy.convert.impl;

import com.wy.convert.ResultConvert;
import com.wy.domain.entity.MinutelyWeather;

public class MinutelyConvert implements ResultConvert<MinutelyWeather> {

    @Override
    public MinutelyWeather doConvert(String resultStr) {
        MinutelyWeather minutelyWeather = new MinutelyWeather();
        System.out.println(resultStr);
        return minutelyWeather;
    }
}
