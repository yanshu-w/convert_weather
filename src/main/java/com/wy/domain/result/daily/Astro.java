package com.wy.domain.result.daily;


import lombok.Data;

@Data
public class Astro {

    private String date;

    private SunTime sunrise;

    private SunTime sunset;


    @Data
    public static
    class SunTime {
        private String time;
    }


}
