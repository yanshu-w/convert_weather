package com.wy.domain.result.daily;


import lombok.Data;

import java.math.BigDecimal;

@Data
public class Wind {

    private String date;

    private WindData max;

    private WindData min;

    private WindData avg;


    @Data
    public static class WindData {

        private BigDecimal speed;

        private BigDecimal direction;
    }

}
