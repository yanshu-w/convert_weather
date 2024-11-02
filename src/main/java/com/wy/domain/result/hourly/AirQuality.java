package com.wy.domain.result.hourly;


import lombok.Data;

import java.util.List;

@Data
public class AirQuality {

    private List<Aqi> aqi;

    private List<Pm25> pm25;

}
