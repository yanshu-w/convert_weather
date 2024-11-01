package com.wy.domain.result.realtime;

import lombok.Data;


@Data
public class Precipitation {

    private Local local;

    private Nearest nearest;

}
