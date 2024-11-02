package com.wy.domain.result.hourly;


import lombok.Data;

@Data
public class Aqi {

    private String datetime;

    private Value value;


    @Data
    public static
    class Value {
        private Integer chn;

        private Integer usa;
    }

}
