package com.wy.domain.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.wy.domain.result.realtime.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

/**
 * 实况天气信息表的实体类
 */
@Data // 自动生成 getter、setter、toString、equals 和 hashCode 方法
@AllArgsConstructor // 全参构造方法
@NoArgsConstructor // 无参构造方法
public class RealtimeWeather {

    /**
     * 主键
     */
    @TableId(type = IdType.AUTO) // 指定主键并设置自增策略
    private Long id;

    /**
     * 状态
     */
    private String status;

    /**
     * 地表 2 米气温
     */
    private Integer temperature;

    /**
     * 地表 2 米湿度相对湿度(%)
     */
    private BigDecimal humidity;

    /**
     * 总云量(0.0-1.0)
     */
    private BigDecimal cloudrate;

    /**
     * 天气现象
     */
    private String skycon;

    /**
     * 地表水平能见度
     */
    private BigDecimal visibility;

    /**
     * 向下短波辐射通量(w/m2)
     */
    private BigDecimal dswrf;

    /**
     * 地表 10 米风速
     */
    private BigDecimal windSpeed;

    /**
     * 地表 10 米风向
     */
    private BigDecimal windDirection;

    /**
     * 地面气压
     */
    private BigDecimal pressure;

    /**
     * 体感温度
     */
    private BigDecimal apparentTemperature;

    /**
     * 本地降水状态
     */
    private String precipitationLocalStatus;

    /**
     * 本地降水数据来源
     */
    private String precipitationLocalDatasource;

    /**
     * 本地降水强度
     */
    private Integer precipitationLocalIntensity;

    /**
     * 最近降水状态
     */
    private String precipitationNearestStatus;

    /**
     * 最近降水带与本地的距离（米）
     */
    private Integer precipitationNearestDistance;

    /**
     * 最近降水强度
     */
    private Integer precipitationNearestIntensity;

    /**
     * pm2.5 浓度（μg/m3）
     */
    private Integer airQualityPm25;

    /**
     * pm10 浓度（μg/m3）
     */
    private Integer airQualityPm10;

    /**
     * 臭氧浓度（μg/m3）
     */
    private Integer airQualityO3;

    /**
     * 二氧化硫浓度（μg/m3）
     */
    private Integer airQualitySo2;

    /**
     * 二氧化氮浓度（μg/m3）
     */
    private Integer airQualityNo2;

    /**
     * 一氧化碳浓度（mg/m3）
     */
    private BigDecimal airQualityCo;

    /**
     * 中国标准 aqi
     */
    private Integer airQualityAqiChn;

    /**
     * 美国标准 aqi
     */
    private Integer airQualityAqiUsa;

    /**
     * 中国 aqi 描述
     */
    private String airQualityDescriptionChn;

    /**
     * 美国 aqi 描述
     */
    private String airQualityDescriptionUsa;

    /**
     * 紫外线指数
     */
    private Integer lifeIndexUltravioletIndex;

    /**
     * 紫外线描述
     */
    private String lifeIndexUltravioletDesc;

    /**
     * 舒适度指数
     */
    private Integer lifeIndexComfortIndex;

    /**
     * 舒适度描述
     */
    private String lifeIndexComfortDesc;

    /**
     * 预报时间
     */
    private Date forecastTime;

    /**
     * 创建时间
     */
    private Date createTime;

    @TableField(exist = false)
    private Wind wind;

    @TableField(exist = false)
    private Precipitation precipitation;

    @TableField(exist = false)
    private AirQuality air_quality;

    @TableField(exist = false)
    private LifeIndex life_index;

    public void setWind(Wind wind) {
        this.wind = wind;
        this.windSpeed = wind.getSpeed();
        this.windDirection = wind.getDirection();
    }

    public void setPrecipitation(Precipitation precipitation) {
        this.precipitation = precipitation;
        Local local = precipitation.getLocal();
        if (!Objects.isNull(local)) {
            this.precipitationLocalStatus = local.getStatus();
            this.precipitationLocalDatasource = local.getDatasource();
            this.precipitationLocalIntensity = local.getIntensity();
        }
        Nearest nearest = precipitation.getNearest();
        if (!Objects.isNull(nearest)) {
            this.precipitationNearestStatus = nearest.getStatus();
            this.precipitationNearestDistance = nearest.getDistance();
            this.precipitationNearestIntensity = nearest.getIntensity();
        }
    }

    public void setAir_quality(AirQuality air_quality) {
        this.air_quality = air_quality;
        this.airQualityPm25 = air_quality.getPm25();
        this.airQualityPm10 = air_quality.getPm10();
        this.airQualityO3 = air_quality.getO3();
        this.airQualitySo2 = air_quality.getSo2();
        this.airQualityNo2 = air_quality.getNo2();
        this.airQualityCo = air_quality.getCo();

        Aqi aqi = air_quality.getAqi();
        if (!Objects.isNull(aqi)) {
            this.airQualityAqiChn = aqi.getChn();
            this.airQualityAqiUsa = aqi.getUsa();
        }

        Description description = air_quality.getDescription();
        if (!Objects.isNull(description)) {
            this.airQualityDescriptionChn = description.getChn();
            this.airQualityDescriptionUsa = description.getUsa();
        }
    }

    public void setLife_index(LifeIndex life_index) {
        this.life_index = life_index;
        Ultraviolet ultraviolet = life_index.getUltraviolet();
        if (!Objects.isNull(ultraviolet)) {
            this.lifeIndexUltravioletIndex = ultraviolet.getIndex();
            this.lifeIndexUltravioletDesc = ultraviolet.getDesc();
        }
        Comfort comfort = life_index.getComfort();
        if (!Objects.isNull(comfort)) {
            this.lifeIndexComfortIndex = comfort.getIndex();
            this.lifeIndexComfortDesc = comfort.getDesc();
        }
    }
}
