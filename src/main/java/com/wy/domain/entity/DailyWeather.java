package com.wy.domain.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 天级天气信息表的实体类
 */
@Data // 自动生成 getter、setter、toString、equals 和 hashCode 方法
@AllArgsConstructor // 全参构造方法
@NoArgsConstructor // 无参构造方法
public class DailyWeather {

    /**
     * 主键
     */
    @TableId(type = IdType.AUTO) // 指定主键并设置自增策略
    private Long id;

    /**
     * 日预报状态
     */
    private String status;

    /**
     * 主要预报
     */
    private Integer primaryForecast;

    /**
     * 日期
     */
    private Date astroDate;

    /**
     * 日出时间
     */
    private Date sunriseTime;

    /**
     * 日落时间
     */
    private Date sunsetTime;

    /**
     * 白天降水日期
     */
    private Date precipitation08h20hDate;

    /**
     * 白天最大降水量
     */
    private Double precipitation08h20hMax;

    /**
     * 白天最小降水量
     */
    private Double precipitation08h20hMin;

    /**
     * 白天平均降水量
     */
    private Double precipitation08h20hAvg;

    /**
     * 白天降水概率
     */
    private Double precipitation08h20hProbability;

    /**
     * 夜晚降水日期
     */
    private Date precipitation20h32hDate;

    /**
     * 夜晚最大降水量
     */
    private Double precipitation20h32hMax;

    /**
     * 夜晚最小降水量
     */
    private Double precipitation20h32hMin;

    /**
     * 夜晚平均降水量
     */
    private Double precipitation20h32hAvg;

    /**
     * 夜晚降水概率
     */
    private Double precipitation20h32hProbability;

    /**
     * 全天降水日期
     */
    private Date precipitationDate;

    /**
     * 全天最大降水量
     */
    private Double precipitationMax;

    /**
     * 全天最小降水量
     */
    private Double precipitationMin;

    /**
     * 全天平均降水量
     */
    private Double precipitationAvg;

    /**
     * 全天降水概率
     */
    private Double precipitationProbability;

    /**
     * 气温日期
     */
    private Date temperatureDate;

    /**
     * 全天最高气温
     */
    private Double temperatureMax;

    /**
     * 全天最低气温
     */
    private Double temperatureMin;

    /**
     * 全天平均气温
     */
    private Double temperatureAvg;

    /**
     * 白天气温日期
     */
    private Date temperature08h20hDate;

    /**
     * 白天最高气温
     */
    private Double temperature08h20hMax;

    /**
     * 白天最低气温
     */
    private Double temperature08h20hMin;

    /**
     * 白天平均气温
     */
    private Double temperature08h20hAvg;

    /**
     * 夜晚气温日期
     */
    private Date temperature20h32hDate;

    /**
     * 夜晚最高气温
     */
    private Double temperature20h32hMax;

    /**
     * 夜晚最低气温
     */
    private Double temperature20h32hMin;

    /**
     * 夜晚平均气温
     */
    private Double temperature20h32hAvg;

    /**
     * 风速日期
     */
    private Date windDate;

    /**
     * 全天最大风速
     */
    private Double windMaxSpeed;

    /**
     * 全天最大风向
     */
    private Double windMaxDirection;

    /**
     * 全天最小风速
     */
    private Double windMinSpeed;

    /**
     * 全天最小风向
     */
    private Double windMinDirection;

    /**
     * 全天平均风速
     */
    private Double windAvgSpeed;

    /**
     * 全天平均风向
     */
    private Double windAvgDirection;

    /**
     * 白天风速日期
     */
    private Date wind08h20hDate;

    /**
     * 白天最大风速
     */
    private Double wind08h20hMaxSpeed;

    /**
     * 白天最大风向
     */
    private Double wind08h20hMaxDirection;

    /**
     * 白天最小风速
     */
    private Double wind08h20hMinSpeed;

    /**
     * 白天最小风向
     */
    private Double wind08h20hMinDirection;

    /**
     * 白天平均风速
     */
    private Double wind08h20hAvgSpeed;

    /**
     * 白天平均风向
     */
    private Double wind08h20hAvgDirection;

    /**
     * 夜晚风速日期
     */
    private Date wind20h32hDate;

    /**
     * 夜晚最大风速
     */
    private Double wind20h32hMaxSpeed;

    /**
     * 夜晚最大风向
     */
    private Double wind20h32hMaxDirection;

    /**
     * 夜晚最小风速
     */
    private Double wind20h32hMinSpeed;

    /**
     * 夜晚最小风向
     */
    private Double wind20h32hMinDirection;

    /**
     * 夜晚平均风速
     */
    private Double wind20h32hAvgSpeed;

    /**
     * 夜晚平均风向
     */
    private Double wind20h32hAvgDirection;

    /**
     * 湿度日期
     */
    private Date humidityDate;

    /**
     * 最大湿度
     */
    private Double humidityMax;

    /**
     * 最小湿度
     */
    private Double humidityMin;

    /**
     * 平均湿度
     */
    private Double humidityAvg;

    /**
     * 云量日期
     */
    private Date cloudrateDate;

    /**
     * 最大云量
     */
    private Double cloudrateMax;

    /**
     * 最小云量
     */
    private Double cloudrateMin;

    /**
     * 平均云量
     */
    private Double cloudrateAvg;

    /**
     * 气压日期
     */
    private Date pressureDate;

    /**
     * 最大气压
     */
    private Double pressureMax;

    /**
     * 最小气压
     */
    private Double pressureMin;

    /**
     * 平均气压
     */
    private Double pressureAvg;

    /**
     * 能见度日期
     */
    private Date visibilityDate;

    /**
     * 最大能见度
     */
    private Double visibilityMax;

    /**
     * 最小能见度
     */
    private Double visibilityMin;

    /**
     * 平均能见度
     */
    private Double visibilityAvg;

    /**
     * 辐射通量日期
     */
    private Date dswrfDate;

    /**
     * 最大辐射通量
     */
    private Double dswrfMax;

    /**
     * 最小辐射通量
     */
    private Double dswrfMin;

    /**
     * 平均辐射通量
     */
    private Double dswrfAvg;

    /**
     * 空气质量日期
     */
    private Date airQualityDate;

    /**
     * 中国 aqi 最大值
     */
    private Integer airQualityAqiMaxChn;

    /**
     * 美国 aqi 最大值
     */
    private Integer airQualityAqiMaxUsa;

    /**
     * 中国 aqi 平均值
     */
    private Integer airQualityAqiAvgChn;

    /**
     * 美国 aqi 平均值
     */
    private Integer airQualityAqiAvgUsa;

    /**
     * 中国 aqi 最小值
     */
    private Integer airQualityAqiMinChn;

    /**
     * 美国 aqi 最小值
     */
    private Integer airQualityAqiMinUsa;

    /**
     * pm2.5 日期
     */
    private Date pm25Date;

    /**
     * pm2.5 最大浓度
     */
    private Double pm25Max;

    /**
     * pm2.5 平均浓度
     */
    private Double pm25Avg;

    /**
     * pm2.5 最小浓度
     */
    private Double pm25Min;

    /**
     * 天气现象日期
     */
    private Date skyconDate;

    /**
     * 全天主要天气现象
     */
    private String skyconValue;

    /**
     * 白天主要天气现象
     */
    private String skycon08h20hValue;

    /**
     * 夜晚主要天气现象
     */
    private String skycon20h32hValue;

    /**
     * 生活指数日期
     */
    private Date lifeIndexDate;

    /**
     * 紫外线指数
     */
    private Integer ultravioletIndex;

    /**
     * 紫外线描述
     */
    private String ultravioletDesc;

    /**
     * 洗车指数
     */
    private Integer carwashingIndex;

    /**
     * 洗车描述
     */
    private String carwashingDesc;

    /**
     * 穿衣指数
     */
    private Integer dressingIndex;

    /**
     * 穿衣描述
     */
    private String dressingDesc;

    /**
     * 舒适度指数
     */
    private Integer comfortIndex;

    /**
     * 预报时间
     */
    private Date forecastTime;

    /**
     * 创建时间
     */
    private Date createTime;
}
