package com.wy.domain.result.realtime;

import lombok.Data;

import java.math.BigDecimal;


@Data
public class AirQuality {

    private Integer pm25;

    private Integer pm10;

    private Integer o3;

    private Integer so2;

    private Integer no2;

    private BigDecimal co;

    private Aqi aqi;

    private Description description;

}
