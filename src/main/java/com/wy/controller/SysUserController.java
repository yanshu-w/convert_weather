package com.wy.controller;


import com.wy.common.core.AjaxResult;
import com.wy.domain.dto.LoginParam;
import com.wy.service.ISysUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sysUser")
@RequiredArgsConstructor
public class SysUserController {

    private final ISysUserService sysUserService;


    @PostMapping("/doLogin")
    public AjaxResult doLogin(@RequestBody LoginParam loginParam) {

        String token = sysUserService.getSysUserPwd(loginParam);

        return AjaxResult.success("登录成功", token);
    }

}
