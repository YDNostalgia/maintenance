package com.gxa.controller;


import com.gxa.dto.SysSettingsDto;
import com.gxa.entity.SysSettings;
import com.gxa.service.SysSettingsService;
import com.gxa.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(tags = "系统设置管理")
public class SysSettingsController {
    @Autowired
    private SysSettingsService sysSettingsService;

    @ApiOperation("系统设置列表")
    @GetMapping("/sys/list")
    public Result<List<SysSettings>> list(){
        List<SysSettings> sysSettings= this.sysSettingsService.queryAll();
        Result<List<SysSettings>> r=Result.success(sysSettings);
        return r;
    }


    /**
     * 系统设置修改
     */
    @ApiOperation("系统设置修改")
    @PutMapping("/sys/update")
    @ResponseBody
    public Result<SysSettings> update(@RequestBody SysSettingsDto sysSettingsDto){
        System.out.println("***********" + sysSettingsDto);
        this.sysSettingsService.update(sysSettingsDto);
        Result<SysSettings> r=Result.success();
        return r;
    }

}
