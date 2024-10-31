package com.wy.domain.dict;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 风向字典表
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("wind_direction_dict")
public class WindDirectionDict {

    /**
     * 自增主键
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 风向名称
     */
    private String directionName;

    /**
     * 风向简称
     */
    private String abbreviation;

    /**
     * 风向角度
     */
    private Integer angle;

    /**
     * 风向角度下限
     */
    private Float minAngle;

    /**
     * 风向角度上限
     */
    private Float maxAngle;
}
