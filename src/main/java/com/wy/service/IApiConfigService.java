package com.wy.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.wy.domain.dto.ApiConfigDto;
import com.wy.domain.dto.UpdateTimeDto;
import com.wy.domain.entity.ApiConfig;
import com.wy.domain.vo.ApiConfigVo;

public interface IApiConfigService extends IService<ApiConfig> {
    String createOne();

    boolean minusTime(String token);

    Integer checkToken(String token);

    boolean updateTimeById(UpdateTimeDto updateTimeDto);

    PageInfo<ApiConfigVo> getPageInfo(ApiConfigDto apiConfigDto);

    boolean overdue(UpdateTimeDto updateTimeDto);
}
