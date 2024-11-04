package com.wy.convert.impl;

import cn.hutool.core.bean.BeanUtil;
import com.wy.common.constant.DictConstant;
import com.wy.convert.ResultConvert;
import com.wy.domain.entity.HourlyWeather;
import com.wy.domain.result.hourly.*;
import com.wy.utils.JsonUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class HourlyConvert implements ResultConvert<List<HourlyWeather>> {
    @Override
    public List<HourlyWeather> doConvert(String resultStr) {
        Map<String, Object> map = JsonUtil.JsonToMap(resultStr, String.class, Object.class);
        HourlyWeather originData = BeanUtil.toBean(map, HourlyWeather.class);

        return getHourlyWeathers(originData);
    }

    private static List<HourlyWeather> getHourlyWeathers(HourlyWeather originData) {

        List<Precipitation> precipitationList = originData.getPrecipitation();
        List<Temperature> temperatureList = originData.getTemperature();
        List<ApparentTemperature> apparentTemperatureList = originData.getApparent_temperature();
        List<Wind> windList = originData.getWind();
        List<Humidity> humidityList = originData.getHumidity();
        List<Cloudrate> cloudrateList = originData.getCloudrate();
        List<Skycon> skyconList = originData.getSkycon();
        List<Pressure> pressureList = originData.getPressure();
        List<Visibility> visibilityList = originData.getVisibility();
        List<Dswrf> dswrfList = originData.getDswrf();
        AirQuality airQuality = originData.getAirQuality();
        List<Aqi> aqiList = airQuality.getAqi();
        List<Pm25> pm25List = airQuality.getPm25();

        List<HourlyWeather> hourlyWeatherList = new ArrayList<>();

        //以降水数据为小时数
        for (int i = 0; i < precipitationList.size(); i++) {

            HourlyWeather hourlyWeather = new HourlyWeather();

            Precipitation precipitation = precipitationList.get(i);
            Temperature temperature = temperatureList.get(i);
            ApparentTemperature apparentTemperature = apparentTemperatureList.get(i);
            Wind wind = windList.get(i);
            Humidity humidity = humidityList.get(i);
            Cloudrate cloudrate = cloudrateList.get(i);
            Skycon skycon = skyconList.get(i);
            Pressure pressure = pressureList.get(i);
            Visibility visibility = visibilityList.get(i);
            Dswrf dswrf = dswrfList.get(i);
            Aqi aqi = aqiList.get(i);
            Pm25 pm25 = pm25List.get(i);

            hourlyWeather.setStatus(originData.getStatus());
            hourlyWeather.setDescription(originData.getDescription());
            hourlyWeather.setPrecipitationDatetime(precipitation.getDatetime());
            hourlyWeather.setPrecipitationValue(precipitation.getValue());
            hourlyWeather.setPrecipitationProbability(precipitation.getProbability());
            hourlyWeather.setTemperatureDatetime(temperature.getDatetime());
            hourlyWeather.setTemperatureValue(temperature.getValue());
            hourlyWeather.setApparentTemperatureDatetime(apparentTemperature.getDatetime());
            hourlyWeather.setApparentTemperatureValue(apparentTemperature.getValue());
            hourlyWeather.setWindDatetime(wind.getDatetime());
            hourlyWeather.setWindDirection(wind.getDirection());
            hourlyWeather.setWindSpeed(wind.getSpeed());
            hourlyWeather.setHumidityDatetime(humidity.getDatetime());
            hourlyWeather.setHumidityValue(humidity.getValue());
            hourlyWeather.setCloudrateDatetime(cloudrate.getDatetime());
            hourlyWeather.setCloudrateValue(cloudrate.getValue());
            hourlyWeather.setSkyconDatetime(skycon.getDatetime());
            hourlyWeather.setSkyconValue(DictConstant.Skycon.getName(skycon.getValue()));
            hourlyWeather.setPressureDatetime(pressure.getDatetime());
            hourlyWeather.setPressureValue(pressure.getValue());
            hourlyWeather.setVisibilityDatetime(visibility.getDatetime());
            hourlyWeather.setVisibilityValue(visibility.getValue());
            hourlyWeather.setDswrfDatetime(dswrf.getDatetime());
            hourlyWeather.setDswrfValue(dswrf.getValue());
            hourlyWeather.setAirQualityAqiDatetime(aqi.getDatetime());
            hourlyWeather.setAirQualityAqiChn(aqi.getValue().getChn());
            hourlyWeather.setAirQualityAqiUsa(aqi.getValue().getUsa());
            hourlyWeather.setAirQualityPm25Datetime(pm25.getDatetime());
            hourlyWeather.setAirQualityPm25Value(pm25.getValue());


            hourlyWeatherList.add(hourlyWeather);
        }
        return hourlyWeatherList;
    }
}
