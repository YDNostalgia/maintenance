package com.gxa.controller;

import com.gxa.utils.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

@RestController
@Api("维修质量接口")
public class KeepQualityController {

    @ApiOperation("维修质量查询")
    @GetMapping("KeepQuality/queryAllKeepQuality")
    public R queryAllKeepQuality(){
        R r = new R();
        return r;
    }
    @ApiOperation("维修质量添加")
    @PostMapping("KeepQuality/addKeepQuality")
    public R addKeepQuality(){
        R r = new R();
        return r;
    }
    @ApiOperation("维修质量修改")
    @PutMapping("KeepQuality/updateKeepQuality")
    public R updateKeepQuality(){
        R r = new R();
        return r;
    }
    @ApiOperation("维修质量删除")
    @DeleteMapping("KeepQuality/deleteKeepQuality")
    public R deleteKeepQuality(){
        R r = new R();
        return r;
    }
}
