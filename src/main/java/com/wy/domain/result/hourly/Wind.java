package com.wy.domain.result.hourly;


import lombok.Data;

import java.math.BigDecimal;

@Data
public class Wind {

    private BigDecimal speed;

    private Integer direction;

    private String datetime;

}
