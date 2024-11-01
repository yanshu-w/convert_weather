package com.wy.utils;


import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.MapType;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Mapper;

import java.util.Map;


@Slf4j
public class JsonUtil {

    private static final ObjectMapper MAPPER = new ObjectMapper();

    public static <K, V> Map<String, Object> JsonToMap(String jsonString, Class<K> keyClass, Class<V> valueClass) {

        if (StringUtils.isBlank(jsonString)) {
            return null;
        }
        MapType mapType = MAPPER.getTypeFactory().constructMapType(Map.class, keyClass, valueClass);

        try {
            return MAPPER.readValue(jsonString, mapType);
        } catch (JsonProcessingException e) {
//            throw new RuntimeException(e);
            log.error("json to map fail:"+e.getMessage());
        }
        return null;

    }


    public static String objectToJson(Object object) {
        try {
            return MAPPER.writerWithDefaultPrettyPrinter().writeValueAsString(object);
        } catch (JsonProcessingException e) {
//            throw new RuntimeException(e);
            log.error("object to json fail:"+e.getMessage());
        }
        return null;
    }

    public static <T> T JsonToTarget(String jsonString, Class<T> tClass) {

        try {
            return MAPPER.readValue(jsonString, tClass);
        } catch (JsonProcessingException e) {
//            throw new RuntimeException(e);
            log.error("json to object fail:"+e.getMessage());
        }
        return null;
    }

}
