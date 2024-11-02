package com.wy.domain.result.daily;


import lombok.Data;

@Data
public class Aqi {

    private String date;

    private Value max;

    private Value avg;

    private Value min;


    @Data
    public static
    class Value {
        private Integer chn;

        private Integer usa;
    }

}
