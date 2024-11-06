package com.wy.domain.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * API配置表的实体类
 */
@Data // 自动生成getter、setter、toString、equals和hashCode方法
@AllArgsConstructor // 全参构造方法
@NoArgsConstructor // 无参构造方法
@TableName("api_config") // 指定数据库表名
public class ApiConfig {

    /**
     * 主键
     */
    @TableId(type = IdType.AUTO) // 指定主键
    private Long id;

    /**
     * API请求次数
     */
    private Integer apiTime;

    /**
     * 随机生成的token
     */
    private String apiToken;

    /**
     * 是否过期，默认为0（未过期）
     */
    private Integer expire;

    /**
     * 记录创建时间
     */
    private Date createTime;

    /**
     * 记录最后一次时间
     */
    private Date lastRequestTime;

    /**
     * 删除标记
     */
    @TableLogic(value = "0", delval = "1")
    private Integer delFlag;
}
