package com.wy.domain.dict;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 错误信息字典表
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("http_status_code_dict")
public class HttpStatusCodeDict {

    /**
     * HTTP 状态码
     */
    @TableId
    private Integer code;

    /**
     * 状态码说明
     */
    private String message;
}
