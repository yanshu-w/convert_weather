package com.wy.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wy.domain.entity.ApiConfig;
import com.wy.mapper.ApiConfigMapper;
import com.wy.service.IApiConfigService;
import com.wy.utils.RandomStringWithTime;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class ApiConfigServiceImpl extends ServiceImpl<ApiConfigMapper, ApiConfig> implements IApiConfigService {


    @Override
    public String createOne() {

        String token = RandomStringWithTime.generateRandomStringWithTime();

        ApiConfig apiConfig = new ApiConfig();
        //默认100次
        apiConfig.setApiTime(100);
        apiConfig.setApiToken(token);
        apiConfig.setExpire(0);
        apiConfig.setCreateTime(new Date());

        this.save(apiConfig);

        return token;
    }

    @Override
    @Transactional
    public boolean minusTime(String token) {

        int count = baseMapper.minusTimeByToken(token);

        return count == 1;
    }

    @Override
    public boolean checkToken(String token) {
        Integer i = baseMapper.checkToken(token);

        return !Objects.equals(Objects.isNull(i) ? 0 : i, 0);
    }
}
