package com.wy.domain.result.hourly;


import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;
import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@Data
public class Precipitation extends HourlyParam {

    private BigDecimal probability;

}
