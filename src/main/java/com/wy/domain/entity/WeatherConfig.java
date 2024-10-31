package com.wy.domain.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 天气请求配置表的实体类
 */
@Data // 自动生成 getter、setter、toString、equals 和 hashCode 方法
@AllArgsConstructor // 全参构造方法
@NoArgsConstructor // 无参构造方法
@TableName("weather_config") // 指定数据库表名
public class WeatherConfig {

    /**
     * 主键
     */
    @TableId(type = IdType.AUTO) // 指定主键并设置自增策略
    private Long id;

    /**
     * 返回状态
     */
    private String status;

    /**
     * API 版本
     */
    private String apiVersion;

    /**
     * API 状态
     */
    private String apiStatus;

    /**
     * 语言
     */
    private String lang;

    /**
     * 单位制，metric表示公制
     */
    private String unit;

    /**
     * 时区偏移秒数
     */
    private Integer tzshift;

    /**
     * 时区信息
     */
    private String timezone;

    /**
     * 服务器时间戳
     */
    private Integer serverTime;

    /**
     * 纬度
     */
    private BigDecimal latitude;

    /**
     * 经度
     */
    private BigDecimal longitude;

    /**
     * 1-实时数据;2-分钟级;3-小时级别;4-天级别
     */
    private Integer type;

    /**
     * _weather系列表的主键
     */
    private Long resultId;

    /**
     * 创建时间
     */
    private Date createTime;
}
