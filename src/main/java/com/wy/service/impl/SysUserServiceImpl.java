package com.wy.service.impl;


import cn.dev33.satoken.stp.StpUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wy.common.exception.ServiceException;
import com.wy.domain.dto.LoginParam;
import com.wy.domain.entity.SysUser;
import com.wy.mapper.SysUserMapper;
import com.wy.service.ISysUserService;
import org.apache.commons.codec.digest.Md5Crypt;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements ISysUserService {

    @Value("${pwd.salt}")
    private String salt;

    @Override
    public String getSysUserPwd(LoginParam loginParam) {
        SysUser sysUser = lambdaQuery().eq(SysUser::getUserName, loginParam.getUserName()).last("limit 1").one();

        if (Objects.isNull(sysUser)) {
            throw new ServiceException("未找到相关账号信息");
        }

        String loginPwd = Md5Crypt.md5Crypt(loginParam.getPassword().getBytes(), salt);

        if (Objects.equals(sysUser.getPassword(), loginPwd)) {
            StpUtil.setLoginId(sysUser.getId() + sysUser.getUserName() + sysUser.getPassword());
            return StpUtil.getTokenValue();
        }

        throw new ServiceException("登录失败；请联系管理员");
    }

}
