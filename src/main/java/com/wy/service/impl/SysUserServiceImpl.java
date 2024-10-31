package com.wy.service.impl;


import cn.dev33.satoken.stp.StpUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wy.common.exception.ServiceException;
import com.wy.domain.dto.LoginParam;
import com.wy.domain.entity.SysUser;
import com.wy.mapper.SysUserMapper;
import com.wy.service.ISysUserService;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements ISysUserService {

    @Override
    public String getSysUserPwd(LoginParam loginParam) {
        SysUser sysUser = lambdaQuery().eq(SysUser::getUserName, loginParam.getUserName()).last("limit 1").one();

        if (Objects.isNull(sysUser)) {
            throw new ServiceException("未找到相关账号信息");
        }

        if (Objects.equals(sysUser.getPassword(), loginParam.getPassword())) {
            StpUtil.setLoginId(sysUser.getId() + sysUser.getUserName() + sysUser.getPassword());
            return StpUtil.getTokenName();
        }

        throw new ServiceException("登录失败；请联系管理员");
    }

}
