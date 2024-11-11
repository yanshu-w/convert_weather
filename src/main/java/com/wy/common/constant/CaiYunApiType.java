package com.wy.common.constant;


import lombok.Getter;

@Getter
public enum CaiYunApiType {

    /**
     * 实况数据
     */
    TYPE_REALTIME(1, "realtime"),

    /**
     * 分钟级降水
     */
    TYPE_MINUTELY(2, "minutely"),

    /**
     * 小时级
     */
    TYPE_HOURLY(3, "hourly"),

    /**
     * 天级
     */
    TYPE_DAILY(4, "daily");


    private final Integer code;
    private final String resultName;

    CaiYunApiType(java.lang.Integer code, String resultName) {
        this.code = code;
        this.resultName = resultName;
    }

}
