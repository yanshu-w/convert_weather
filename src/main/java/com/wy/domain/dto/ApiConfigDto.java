package com.wy.domain.dto;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;


@EqualsAndHashCode(callSuper = true)
@Data
public class ApiConfigDto extends PageParam {

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
}
