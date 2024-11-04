package com.wy.domain.result.hourly;


import lombok.Data;

import java.util.Objects;

@Data
public class Aqi {

    private String datetime;

    private Value value;

    public Value getValue() {
        return Objects.isNull(value) ? new Value() : value;
    }

    @Data
    public static
    class Value {
        private Integer chn;

        private Integer usa;
    }

}
