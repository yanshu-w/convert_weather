package com.wy.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wy.domain.dto.ApiConfigDto;
import com.wy.domain.dto.UpdateTimeDto;
import com.wy.domain.entity.ApiConfig;
import com.wy.domain.vo.ApiConfigVo;
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
    public Integer checkToken(String token) {

        return baseMapper.checkToken(token);
    }

    @Override
    public boolean updateTimeById(UpdateTimeDto updateTimeDto) {
        boolean update = lambdaUpdate().set(ApiConfig::getApiTime, updateTimeDto.getApiTime()).eq(ApiConfig::getId,
                updateTimeDto.getId()).update();
        return update;
    }

    @Override
    public PageInfo<ApiConfigVo> getPageInfo(ApiConfigDto apiConfigDto) {

        PageInfo<ApiConfigVo> objects =
                PageHelper.startPage(apiConfigDto.getCurrent(), apiConfigDto.getPageSize()).doSelectPageInfo(() -> baseMapper.getPageList(apiConfigDto));


        return objects;
    }

    @Override
    public boolean overdue(UpdateTimeDto updateTimeDto) {
        boolean update = lambdaUpdate().set(ApiConfig::getExpire, updateTimeDto.getExpire()).eq(ApiConfig::getId,
                updateTimeDto.getId()).update();
        return update;
    }
}
