package com.wy.domain.entity;


import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 实况数据
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("realtime")
public class Realtime {

    private String status;

}
