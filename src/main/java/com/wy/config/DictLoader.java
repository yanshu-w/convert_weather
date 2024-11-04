package com.wy.config;


import com.wy.common.constant.DictConstant;
import com.wy.mapper.DictMapper;
import com.wy.service.IDictService;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class DictLoader implements ApplicationRunner {

    @Resource
    private IDictService dictService;

    @Override
    public void run(ApplicationArguments args) {
        //天气现象
        DictConstant.Skycon.init(dictService.loadWeatherConditionDict());
    }
}
