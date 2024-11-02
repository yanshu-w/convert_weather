package com.wy.domain.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 接受从mqtt传过来的数据
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MqttParam {

    /**
     * 类型
     */
    private Integer type;

    /**
     * 签名
     */
    private String token;

    /**
     * 小时级
     */
    private Integer hourlySteps;

    /**
     * 天级
     */
    private Integer dailySteps;

    /**
     * 纬度
     */
    private String lat;

    /**
     * 经度
     */
    private String lon;

    /**
     * 通知主题
     */
    private String noticeTopic;

    /**
     * 通知URL
     */
    private String broker;

    /**
     * 账号
     */
    private String username;

    /**
     * 密码
     */
    private String password;

}
