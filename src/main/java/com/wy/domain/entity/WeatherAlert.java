package com.wy.domain.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 天气预警信息表的实体类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class WeatherAlert {

    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 预警信息状态
     */
    private String status;

    /**
     * 省份
     */
    private String alertProvince;

    /**
     * 预警状态
     */
    private String alertStatus;

    /**
     * 预警代码
     */
    private String alertCode;

    /**
     * 预警描述
     */
    private String alertDescription;

    /**
     * 地区 ID
     */
    private String regionId;

    /**
     * 县区
     */
    private String county;

    /**
     * 发布时间戳
     */
    private Integer pubTimestamp;

    /**
     * 纬度
     */
    private Double lat;

    /**
     * 经度
     */
    private Double lon;

    /**
     * 城市
     */
    private String alertCity;

    /**
     * 预警 ID
     */
    private String alertId;

    /**
     * 预警标题
     */
    private String alertTitle;

    /**
     * 区域代码
     */
    private String adcode;

    /**
     * 区域名称
     */
    private String adcodeName;

    /**
     * 预警信息来源
     */
    private String source;

    /**
     * 地点
     */
    private String location;

    /**
     * 请求状态
     */
    private String requestStatus;

    /**
     * 预报时间
     */
    private Date forecastTime;

    /**
     * 创建时间
     */
    private Date createTime;
}
