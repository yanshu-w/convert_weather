package com.wy.server;

import cn.hutool.http.HttpUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author wAng
 * @date 2024/10/31 16:36
 */

@Component
public class WeatherServer {

    @Value("${caiyun.url}")
    private String url;

    @Value("${caiyun.token}")
    private String token;

    @Value("${caiyun.version}")
    private String version;


    public void getWeather() {

        StringBuilder stringBuilder = new StringBuilder();

        String weaUrl =
                stringBuilder.append(url).append("/").append(token).append("/").append("101.6656,39.2072/realtime").toString();

        String s = HttpUtil.get(weaUrl);

        System.out.println(s);

    }

}
