package com.wy.domain.result.realtime;


import lombok.Data;

@Data
public class Nearest {

    private String status;

    private Integer distance;

    private Integer intensity;

}
