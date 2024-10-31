package com.wy.domain.dict;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 风速等级字典表
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("wind_level_dict")
public class WindLevelDict {

    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 风速范围下限 (km/h)
     */
    private Float minSpeed;

    /**
     * 风速范围上限 (km/h)，null 表示无上限
     */
    private Float maxSpeed;

    /**
     * 风速强度范围下限 (m/s)
     */
    private Float minIntensity;

    /**
     * 风速强度范围上限 (m/s)，null 表示无上限
     */
    private Float maxIntensity;

    /**
     * 风速等级描述
     */
    private String levelDescription;
}
