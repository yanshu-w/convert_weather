package com.wy.domain.dict;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 洗车指数字典表
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("carWashing_dict")
public class CarWashingDict {
    
    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 描述
     */
    private String description;
}
