package com.wy.utils;

import cn.hutool.core.collection.CollUtil;
import com.wy.utils.anno.NotNull;
import org.springframework.util.CollectionUtils;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class NotNullChecker {


    public static List<String> haveNull(Object object) throws Exception {


        Field[] fields = object.getClass().getFields();

        List<String> fieldNames = new ArrayList<>();

        for (Field field : fields) {

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
    }


}
