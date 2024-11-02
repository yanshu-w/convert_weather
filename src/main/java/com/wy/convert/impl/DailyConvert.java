package com.wy.convert.impl;

import cn.hutool.core.bean.BeanUtil;
import com.wy.convert.ResultConvert;
import com.wy.domain.entity.DailyWeather;
import com.wy.domain.result.daily.*;
import com.wy.utils.JsonUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DailyConvert implements ResultConvert<List<DailyWeather>> {
    @Override
    public List<DailyWeather> doConvert(String resultStr) {
        Map<String, Object> map = JsonUtil.JsonToMap(resultStr, String.class, Object.class);
        DailyWeather originData = BeanUtil.toBean(map, DailyWeather.class);

        return getDailyWeathers(originData);
    }

    private List<DailyWeather> getDailyWeathers(DailyWeather originData) {

        List<Astro> astroList = originData.getAstro();
        List<Precipitation> precipitation08h20hList = originData.getPrecipitation_08h_20h();
        List<Precipitation> precipitation20h32hList = originData.getPrecipitation_20h_32h();
        List<Precipitation> precipitationList = originData.getPrecipitation();
        List<Temperature> temperatureList = originData.getTemperature();
        List<Temperature> temperature08h20hList = originData.getTemperature_08h_20h();
        List<Temperature> temperature20h32hList = originData.getTemperature_20h_32h();
        List<Wind> windList = originData.getWind();
        List<Wind> wind08h20hList = originData.getWind_08h_20h();
        List<Wind> wind20h32hList = originData.getWind_20h_32h();
        List<Humidity> humidityList = originData.getHumidity();
        List<Cloudrate> cloudrateList = originData.getCloudrate();
        List<Pressure> pressureList = originData.getPressure();
        List<Visibility> visibilityList = originData.getVisibility();
        List<Dswrf> dswrfList = originData.getDswrf();
        AirQuality airQuality = originData.getAir_quality();
        List<Aqi> aqiList = airQuality.getAqi();
        List<Pm25> pm25List = airQuality.getPm25();
        List<Skycon> skyconList = originData.getSkycon();
        List<Skycon> skycon08h20hList = originData.getSkycon_08h_20h();
        List<Skycon> skycon20h32hList = originData.getSkycon_20h_32h();
        LifeIndex lifeIndex = originData.getLife_index();
        List<LifeIndex.Value> ultravioletList = lifeIndex.getUltraviolet();
        List<LifeIndex.Value> carWashingList = lifeIndex.getCarWashing();
        List<LifeIndex.Value> dressingList = lifeIndex.getDressing();
        List<LifeIndex.Value> comfortList = lifeIndex.getComfort();
        List<LifeIndex.Value> coldRiskList = lifeIndex.getColdRisk();


        List<DailyWeather> dailyWeatherList = new ArrayList<>();

        //以日出日落时间为天数
        for (int i = 0; i < astroList.size(); i++) {

            Astro astro = astroList.get(i);
            Precipitation precipitation08h20h = precipitation08h20hList.get(i);
            Precipitation precipitation20h32h = precipitation20h32hList.get(i);
            Precipitation precipitation = precipitationList.get(i);
            Temperature temperature = temperatureList.get(i);
            Temperature temperature08h20h = temperature08h20hList.get(i);
            Temperature temperature20h32h = temperature20h32hList.get(i);
            Wind wind = windList.get(i);
            Wind wind08h20h = wind08h20hList.get(i);
            Wind wind20h32h = wind20h32hList.get(i);
            Humidity humidity = humidityList.get(i);
            Cloudrate cloudrate = cloudrateList.get(i);
            Pressure pressure = pressureList.get(i);
            Visibility visibility = visibilityList.get(i);
            Dswrf dswrf = dswrfList.get(i);
            Aqi aqi = aqiList.get(i);
            Pm25 pm25 = pm25List.get(i);
            Skycon skycon = skyconList.get(i);
            Skycon skycon08h20h = skycon08h20hList.get(i);
            Skycon skycon20h32h = skycon20h32hList.get(i);
            LifeIndex.Value ultraviolet = ultravioletList.get(i);
            LifeIndex.Value carWashing = carWashingList.get(i);
            LifeIndex.Value dressing = dressingList.get(i);
            LifeIndex.Value comfort = comfortList.get(i);
            LifeIndex.Value coldRisk = coldRiskList.get(i);

            DailyWeather dailyWeather = new DailyWeather();
            
            dailyWeather.setStatus(originData.getStatus());
            dailyWeather.setAstroDate(astro.getDate());
            dailyWeather.setSunriseTime(astro.getSunrise().getTime());
            dailyWeather.setSunsetTime(astro.getSunset().getTime());
            dailyWeather.setPrecipitation08h20hDate(precipitation08h20h.getDate());
            dailyWeather.setPrecipitation08h20hMax(precipitation08h20h.getMax());
            dailyWeather.setPrecipitation08h20hMin(precipitation08h20h.getMin());
            dailyWeather.setPrecipitation08h20hAvg(precipitation08h20h.getAvg());
            dailyWeather.setPrecipitation08h20hProbability(precipitation08h20h.getProbability());
            dailyWeather.setPrecipitation20h32hDate(precipitation20h32h.getDate());
            dailyWeather.setPrecipitation20h32hMax(precipitation20h32h.getMax());
            dailyWeather.setPrecipitation20h32hMin(precipitation20h32h.getMin());
            dailyWeather.setPrecipitation20h32hAvg(precipitation20h32h.getAvg());
            dailyWeather.setPrecipitation20h32hProbability(precipitation20h32h.getProbability());
            dailyWeather.setPrecipitationDate(precipitation.getDate());
            dailyWeather.setPrecipitationMax(precipitation.getMax());
            dailyWeather.setPrecipitationMin(precipitation.getMin());
            dailyWeather.setPrecipitationAvg(precipitation.getAvg());
            dailyWeather.setPrecipitationProbability(precipitation.getProbability());
            dailyWeather.setTemperatureDate(temperature.getDate());
            dailyWeather.setTemperatureMax(temperature.getMax());
            dailyWeather.setTemperatureMin(temperature.getMin());
            dailyWeather.setTemperatureAvg(temperature.getAvg());
            dailyWeather.setTemperature08h20hDate(temperature08h20h.getDate());
            dailyWeather.setTemperature08h20hMax(temperature08h20h.getMax());
            dailyWeather.setTemperature08h20hMin(temperature08h20h.getMin());
            dailyWeather.setTemperature08h20hAvg(temperature08h20h.getAvg());
            dailyWeather.setTemperature20h32hDate(temperature20h32h.getDate());
            dailyWeather.setTemperature20h32hMax(temperature20h32h.getMax());
            dailyWeather.setTemperature20h32hMin(temperature20h32h.getMin());
            dailyWeather.setTemperature20h32hAvg(temperature20h32h.getAvg());
            dailyWeather.setWindDate(wind.getDate());
            dailyWeather.setWindMaxSpeed(wind.getMax().getSpeed());
            dailyWeather.setWindMaxDirection(wind.getMax().getDirection());
            dailyWeather.setWindMinSpeed(wind.getMin().getSpeed());
            dailyWeather.setWindMinDirection(wind.getMin().getDirection());
            dailyWeather.setWindAvgSpeed(wind.getAvg().getSpeed());
            dailyWeather.setWindAvgDirection(wind.getAvg().getDirection());
            dailyWeather.setWind08h20hDate(wind08h20h.getDate());
            dailyWeather.setWind08h20hMaxSpeed(wind08h20h.getMax().getSpeed());
            dailyWeather.setWind08h20hMaxDirection(wind08h20h.getMax().getDirection());
            dailyWeather.setWind08h20hMinSpeed(wind08h20h.getMin().getSpeed());
            dailyWeather.setWind08h20hMinDirection(wind08h20h.getMin().getDirection());
            dailyWeather.setWind08h20hAvgSpeed(wind08h20h.getAvg().getSpeed());
            dailyWeather.setWind08h20hAvgDirection(wind08h20h.getAvg().getDirection());
            dailyWeather.setWind20h32hDate(wind20h32h.getDate());
            dailyWeather.setWind20h32hMaxSpeed(wind20h32h.getMax().getSpeed());
            dailyWeather.setWind20h32hMaxDirection(wind20h32h.getMax().getDirection());
            dailyWeather.setWind20h32hMinSpeed(wind20h32h.getMin().getSpeed());
            dailyWeather.setWind20h32hMinDirection(wind20h32h.getMin().getDirection());
            dailyWeather.setWind20h32hAvgSpeed(wind20h32h.getAvg().getSpeed());
            dailyWeather.setWind20h32hAvgDirection(wind20h32h.getAvg().getDirection());
            dailyWeather.setHumidityDate(humidity.getDate());
            dailyWeather.setHumidityMax(humidity.getMax());
            dailyWeather.setHumidityMin(humidity.getMin());
            dailyWeather.setHumidityAvg(humidity.getAvg());
            dailyWeather.setCloudrateDate(cloudrate.getDate());
            dailyWeather.setCloudrateMax(cloudrate.getMax());
            dailyWeather.setCloudrateMin(cloudrate.getMin());
            dailyWeather.setCloudrateAvg(cloudrate.getAvg());
            dailyWeather.setPressureDate(pressure.getDate());
            dailyWeather.setPressureMax(pressure.getMax());
            dailyWeather.setPressureMin(pressure.getMin());
            dailyWeather.setPressureAvg(pressure.getAvg());
            dailyWeather.setVisibilityDate(visibility.getDate());
            dailyWeather.setVisibilityMax(visibility.getMax());
            dailyWeather.setVisibilityMin(visibility.getMin());
            dailyWeather.setVisibilityAvg(visibility.getAvg());
            dailyWeather.setDswrfDate(dswrf.getDate());
            dailyWeather.setDswrfMax(dswrf.getMax());
            dailyWeather.setDswrfMin(dswrf.getMin());
            dailyWeather.setDswrfAvg(dswrf.getAvg());
            dailyWeather.setAirQualityDate(aqi.getDate());
            dailyWeather.setAirQualityAqiMaxChn(aqi.getMax().getChn());
            dailyWeather.setAirQualityAqiMaxUsa(aqi.getMax().getUsa());
            dailyWeather.setAirQualityAqiMinChn(aqi.getMin().getChn());
            dailyWeather.setAirQualityAqiMinUsa(aqi.getMin().getUsa());
            dailyWeather.setAirQualityAqiAvgChn(aqi.getAvg().getChn());
            dailyWeather.setAirQualityAqiAvgUsa(aqi.getAvg().getUsa());
            dailyWeather.setPm25Date(pm25.getDate());
            dailyWeather.setPm25Max(pm25.getMax());
            dailyWeather.setPm25Min(pm25.getMin());
            dailyWeather.setPm25Avg(pm25.getAvg());
            dailyWeather.setSkyconDate(skycon.getDate());
            dailyWeather.setSkyconValue(skycon.getValue());
            dailyWeather.setSkycon08h20hValue(skycon08h20h.getValue());
            dailyWeather.setSkycon20h32hValue(skycon20h32h.getValue());
            dailyWeather.setLifeIndexDate(ultraviolet.getDate());
            dailyWeather.setUltravioletIndex(ultraviolet.getIndex());
            dailyWeather.setUltravioletDesc(ultraviolet.getDesc());
            dailyWeather.setCarwashingIndex(carWashing.getIndex());
            dailyWeather.setCarwashingDesc(carWashing.getDesc());
            dailyWeather.setDressingIndex(dressing.getIndex());
            dailyWeather.setDressingDesc(dressing.getDesc());
            dailyWeather.setComfortIndex(comfort.getIndex());
            dailyWeather.setComfortDesc(comfort.getDesc());
            dailyWeather.setColdRiskIndex(coldRisk.getIndex());
            dailyWeather.setColdRiskDesc(coldRisk.getDesc());


            dailyWeatherList.add(dailyWeather);

        }
        return dailyWeatherList;
    }
}
