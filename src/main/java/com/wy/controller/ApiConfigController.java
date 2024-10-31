package com.wy.controller;

import cn.dev33.satoken.annotation.SaCheckLogin;
import com.wy.common.core.AjaxResult;
import com.wy.service.IApiConfigService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/apiConfig")
@RequiredArgsConstructor
@SaCheckLogin
public class ApiConfigController {

    private final IApiConfigService apiConfigService;


    /**
     * 创建一个密钥
     */
    @PostMapping("/createToken")
    public AjaxResult createToken() {

        return AjaxResult.error();
    }

    /**
     * 修改密钥的可用次数
     */
    @PostMapping("/updateTime")
    public AjaxResult updateTime() {

        return AjaxResult.error();
    }

    /**
     * 查看所有密钥
     */
    @PostMapping("/getPage")
    public AjaxResult getPage() {

        return AjaxResult.error();
    }
}
