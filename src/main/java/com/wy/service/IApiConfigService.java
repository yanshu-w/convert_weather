package com.wy.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wy.domain.entity.ApiConfig;

public interface IApiConfigService extends IService<ApiConfig> {
    String createOne();

    boolean minusTime(String token);

    boolean checkToken(String token);
}
