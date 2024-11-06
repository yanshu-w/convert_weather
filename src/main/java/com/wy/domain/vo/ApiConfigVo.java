package com.wy.domain.vo;

import lombok.Data;

import java.util.Date;


@Data
public class ApiConfigVo {

    /**
     * 主键
     */
    private Long id;

    /**
     * API请求次数
     */
    private Integer apiTime;

    /**
     * 随机生成的token
     */
    private String apiToken;

    /**
     * 是否过期，默认为0（未过期）
     */
    private Integer expire;

    /**
     * 记录创建时间
     */
    private Date createTime;

    /**
     * 最后一次请求时间
     */
    private Date lastRequestTime;
}
