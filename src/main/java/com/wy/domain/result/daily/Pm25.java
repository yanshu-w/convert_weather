package com.wy.domain.result.daily;


import lombok.Data;

import java.math.BigDecimal;

@Data
public class Pm25 {

    private String date;

    private BigDecimal max;

    private BigDecimal min;

    private BigDecimal avg;

}
