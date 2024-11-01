package com.wy.domain.result.realtime;


import lombok.Data;

import java.math.BigDecimal;

@Data
public class Wind {

    private BigDecimal speed;

    private BigDecimal direction;

}
