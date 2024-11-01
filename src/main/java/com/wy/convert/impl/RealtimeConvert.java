package com.wy.convert.impl;


import cn.hutool.core.bean.BeanUtil;
import com.wy.convert.ResultConvert;
import com.wy.domain.entity.RealtimeWeather;
import com.wy.utils.JsonUtil;

import java.util.Date;
import java.util.Map;

public class RealtimeConvert implements ResultConvert<RealtimeWeather> {

    @Override
    public RealtimeWeather doConvert(String resultStr) {
        Map<String, Object> map = JsonUtil.JsonToMap(resultStr, String.class, Object.class);
        RealtimeWeather realtimeWeather = BeanUtil.toBean(map, RealtimeWeather.class);
        realtimeWeather.setCreateTime(new Date());
        realtimeWeather.setForecastTime(new Date());
        return realtimeWeather;
    }
}
