package com.wy.domain.dict;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 降水强度字典表
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("precipitation_condition_dict")
public class PrecipitationConditionDict {
    
    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 降水类型 (雨/雪)
     */
    private String precipitationType;

    /**
     * 最小降水量范围
     */
    private Float minPrecipitation;

    /**
     * 最大降水量范围，null 表示无上限
     */
    private Float maxPrecipitation;

    /**
     * 最小降水强度范围
     */
    private Float minIntensity;

    /**
     * 最大降水强度范围，null 表示无上限
     */
    private Float maxIntensity;

    /**
     * 降水等级描述
     */
    private String conditionDescription;
}
