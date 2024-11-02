package com.wy.domain.result.hourly;


import lombok.Data;

import java.math.BigDecimal;

@Data
public class Pm25 {

    private String datetime;

    private BigDecimal value;

}
