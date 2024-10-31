package com.wy.domain.dict;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 紫外线底字典表（天级别）
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("ultraviolet_daily_dict")
public class UltravioletDailyDict {
    
    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 等级描述
     */
    private String levelDesc;
}
