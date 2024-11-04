package com.wy.domain.dto;


import lombok.Data;

@Data
public class UpdateTimeDto {

    private Long id;

    private Integer apiTime;

    private Integer expire;

}
