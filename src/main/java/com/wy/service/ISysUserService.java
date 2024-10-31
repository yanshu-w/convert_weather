package com.wy.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wy.domain.dto.LoginParam;
import com.wy.domain.entity.SysUser;

public interface ISysUserService extends IService<SysUser> {


    String getSysUserPwd(LoginParam loginParam);

}
