package com.wy.domain.dict;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 天气现象字典表的实体类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("weather_condition_dict")
public class WeatherConditionDict {

    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 天气现象名称
     */
    private String conditionName;

    /**
     * 天气现象代码
     */
    private String conditionCode;

    /**
     * 天气条件描述
     */
    private String description;
}
