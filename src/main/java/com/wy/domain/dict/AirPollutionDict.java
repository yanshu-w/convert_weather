package com.wy.domain.dict;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 空气污染字典表的实体类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("air_pollution_dict")
public class AirPollutionDict {

    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * AQI 描述
     */
    private String aqiDesc;
}
