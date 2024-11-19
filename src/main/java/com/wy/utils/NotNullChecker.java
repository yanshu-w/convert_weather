package com.wy.utils;

import cn.hutool.core.collection.CollUtil;
import com.wy.utils.anno.NotNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.CollectionUtils;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Slf4j
public class NotNullChecker {


    public static List<String> getNullFieldNames(Object object) {

        try {
            Field[] fields = object.getClass().getDeclaredFields();

            List<String> fieldNames = new ArrayList<>();

            for (Field field : fields) {
                field.setAccessible(true);
                NotNull annotation = field.getAnnotation(NotNull.class);
                if (Objects.isNull(annotation)) {
                    continue;
                }
                Object value = field.get(object);
                if (Objects.isNull(value)) {
                    fieldNames.add(field.getName());
                }
            }
            return fieldNames;
        } catch (Exception e) {
            log.error(PrintErrorUtil.print(e));
//            throw new RuntimeException();
        }
        return List.of();
    }


}
