package com.wy.domain.entity;


import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 分钟级降水
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("minutely")
public class Minutely {

    private String status;

}
