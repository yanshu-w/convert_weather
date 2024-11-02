package com.wy.domain.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.wy.domain.result.hourly.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/**
 * 小时级天气信息实体类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class HourlyWeather {
    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 小时级别预报状态
     */
    private String status;

    /**
     * 未来24小时天气描述
     */
    private String description;

    /**
     * 主要预报
     */
    private Integer primaryForecast;

    /**
     * 天气预报关键点
     */
    private String forecastKeypoint;

    /**
     * 降水时间
     */
    private String precipitationDatetime;

    /**
     * 降水量
     */
    private BigDecimal precipitationValue;

    /**
     * 降水概率
     */
    private BigDecimal precipitationProbability;

    /**
     * 气温时间
     */
    private String temperatureDatetime;

    /**
     * 地表2米气温
     */
    private BigDecimal temperatureValue;

    /**
     * 体感温度时间
     */
    private String apparentTemperatureDatetime;

    /**
     * 体感温度
     */
    private BigDecimal apparentTemperatureValue;

    /**
     * 风数据时间
     */
    private String windDatetime;

    /**
     * 风速
     */
    private BigDecimal windSpeed;

    /**
     * 风向
     */
    private Integer windDirection;

    /**
     * 湿度时间
     */
    private String humidityDatetime;

    /**
     * 相对湿度
     */
    private BigDecimal humidityValue;

    /**
     * 云量时间
     */
    private String cloudrateDatetime;

    /**
     * 云量
     */
    private BigDecimal cloudrateValue;

    /**
     * 天气现象时间
     */
    private String skyconDatetime;

    /**
     * 天气现象
     */
    private String skyconValue;

    /**
     * 气压时间
     */
    private String pressureDatetime;

    /**
     * 地面气压
     */
    private BigDecimal pressureValue;

    /**
     * 能见度时间
     */
    private String visibilityDatetime;

    /**
     * 水平能见度
     */
    private BigDecimal visibilityValue;

    /**
     * 辐射通量时间
     */
    private String dswrfDatetime;

    /**
     * 向下短波辐射通量
     */
    private BigDecimal dswrfValue;

    /**
     * 空气质量时间
     */
    private String airQualityAqiDatetime;

    /**
     * 中国aqi
     */
    private Integer airQualityAqiChn;

    /**
     * 美国aqi
     */
    private Integer airQualityAqiUsa;

    /**
     * pm2.5浓度时间
     */
    private String airQualityPm25Datetime;

    /**
     * pm2.5浓度
     */
    private BigDecimal airQualityPm25Value;

    /**
     * 预报时间
     */
    private Date forecastTime;

    /**
     * 创建时间
     */
    private Date createTime;

    private List<Precipitation> precipitation;

    private List<Temperature> temperature;

    private List<ApparentTemperature> apparent_temperature;

    private List<Wind> wind;

    private List<Humidity> humidity;

    private List<Cloudrate> cloudrate;

    private List<Skycon> skycon;

    private List<Pressure> pressure;

    private List<Visibility> visibility;

    private List<Dswrf> dswrf;

    private AirQuality airQuality;

}