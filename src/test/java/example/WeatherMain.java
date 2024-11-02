package example;

import cn.hutool.core.util.StrUtil;
import cn.hutool.http.HttpUtil;

import java.util.HashMap;

/**
 * @author wAng
 * @date 2024/10/30 13:04
 */
public class WeatherMain {

    public static void main(String[] args) {

        String api_key = "pjgwFxZMzaqWSEV6";
        String latitude = "34.6860";
        String longitude = "116.6461";
        String hourlysteps = "1";
        String url = StrUtil.format("https://api.caiyunapp.com/v2.6/{api_key}/{longitude}," + "{latitude}/hourly" +
                "?hourlysteps={hourlysteps}", new HashMap<String, String>() {{
            put("api_key", api_key);
            put("latitude", latitude);
            put("longitude", longitude);
            put("hourlysteps", hourlysteps);

        }});

        String s = HttpUtil.get(url);
        //转对象 入库  发起mqtt
        System.out.println(s);

    }


}
