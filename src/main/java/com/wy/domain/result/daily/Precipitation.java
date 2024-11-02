package com.wy.domain.result.daily;


import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;

@EqualsAndHashCode(callSuper = true)
@Data
public class Precipitation extends DailyParam {

    private BigDecimal probability;

}
