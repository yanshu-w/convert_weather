package com.wy.domain.result.hourly;

import lombok.Data;

import java.math.BigDecimal;


@Data
public class HourlyParam {

    private String datetime;

    private BigDecimal value;
}
