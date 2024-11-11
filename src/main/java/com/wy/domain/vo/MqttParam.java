package com.wy.domain.vo;

import com.wy.utils.anno.NotNull;
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
    @NotNull
    private Integer type;

    /**
     * 签名
     */
    @NotNull
    private String token;

    /**
     * 小时级
     */
    @NotNull
    private Integer hourlySteps;

    /**
     * 天级
     */
    @NotNull
    private Integer dailySteps;

    /**
     * 纬度
     */
    @NotNull
    private String lat;

    /**
     * 经度
     */
    @NotNull
    private String lon;

    /**
     * 通知主题
     */
    @NotNull
    private String noticeTopic;

    /**
     * 通知URL
     */
    @NotNull
    private String broker;

    /**
     * 账号
     */
    @NotNull
    private String username;

    /**
     * 密码
     */
    @NotNull
    private String password;

}
