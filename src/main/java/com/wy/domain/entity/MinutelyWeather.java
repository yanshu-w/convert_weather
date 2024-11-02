package com.wy.domain.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 分钟级天气信息表的实体类
 */
@Data // 自动生成 getter、setter、toString、equals 和 hashCode 方法
@AllArgsConstructor // 全参构造方法
@NoArgsConstructor // 无参构造方法
public class MinutelyWeather {

    /**
     * 主键
     */
    @TableId(type = IdType.AUTO) // 指定主键并设置自增策略
    private Long id;

    /**
     * 分钟级预报状态
     */
    private String status;

    /**
     * 数据源
     */
    private String datasource;

    /**
     * 未来2小时每分钟的雷达降水强度
     */
    private String precipitation2h;

    /**
     * 未来1小时每分钟的雷达降水强度
     */
    private String precipitation;

    /**
     * 未来两小时每半小时的降水概率
     */
    private String probability;

    /**
     * 预报描述
     */
    private String description;

    /**
     * 主要预报
     */
    private Integer primaryForecast;

    /**
     * 预报关键点
     */
    private String forecastKeypoint;

    /**
     * 预报时间
     */
    private Date forecastTime;

    /**
     * 创建时间
     */
    private Date createTime;
}
