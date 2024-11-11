package com.wy.controller;

import cn.dev33.satoken.annotation.SaCheckLogin;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.wy.common.constant.HttpMsg;
import com.wy.common.core.AjaxResult;
import com.wy.domain.dto.ApiConfigDto;
import com.wy.domain.dto.UpdateTimeDto;
import com.wy.domain.vo.ApiConfigVo;
import com.wy.service.IApiConfigService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


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
        return AjaxResult.success(HttpMsg.CREATE, apiConfigService.createOne());
    }

    /**
     * 修改密钥的可用次数
     */
    @PostMapping("/updateTime")
    public AjaxResult updateTime(@RequestBody UpdateTimeDto updateTimeDto) {
        boolean b = apiConfigService.updateTimeById(updateTimeDto);
        return AjaxResult.success(b);
    }

    /**
     * 过期
     */
    @PostMapping("/overdue")
    public AjaxResult overdue(@RequestBody UpdateTimeDto updateTimeDto) {
        boolean b = apiConfigService.overdue(updateTimeDto);
        return AjaxResult.success(b);
    }

    /**
     * 查看所有密钥
     */
    @PostMapping("/getPage")
    public AjaxResult getPage(@RequestBody ApiConfigDto apiConfigDto) {

        PageInfo<ApiConfigVo> pageInfo = apiConfigService.getPageInfo(apiConfigDto);

        return AjaxResult.success(pageInfo);
    }

    /**
     * 删除
     */
    @PostMapping("/remove")
    public AjaxResult remove(@RequestParam Long id) {
        boolean b = apiConfigService.removeById(id);
        return AjaxResult.success(b);
    }
}
