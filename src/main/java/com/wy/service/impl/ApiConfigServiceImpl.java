package com.wy.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wy.domain.entity.ApiConfig;
import com.wy.mapper.ApiConfigMapper;
import com.wy.service.IApiConfigService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ApiConfigServiceImpl extends ServiceImpl<ApiConfigMapper, ApiConfig> implements IApiConfigService {


}
