package com.wy.utils;

import lombok.Getter;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {


    @Getter
    enum FORMAT {

        TYPE_1("yyyyMMddHHmmss");


        private final String value;

        FORMAT(java.lang.String value) {
            this.value = value;
        }

    }


    public static String getCurrentTime(FORMAT format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format.value);
        return sdf.format(new Date()); // 返回格式化后的当前时间
    }

}
