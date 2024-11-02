package com.wy.domain.result.daily;


import lombok.Data;

import java.util.List;

@Data
public class LifeIndex {

    private List<Value> ultraviolet;

    private List<Value> carWashing;

    private List<Value> dressing;

    private List<Value> comfort;

    private List<Value> coldRisk;


    @Data
    public static
    class Value {

        private String date;

        private Integer index;

        private String desc;

    }
}
