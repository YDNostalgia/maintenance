package com.gxa.controller;

import com.gxa.utils.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

@RestController
@Api("维修经费接口")
public class KeepFundsContrlloer {
    @ApiOperation("维修经费查询")
    @GetMapping("KeepFunds/queryAllKeepFunds")
    public R queryAllKeepFunds(){
        R r = new R();
        return r;
    }
    @ApiOperation("维修经费添加")
    @PostMapping("KeepFunds/addKeepFunds")
    public R addKeepFunds(){
        R r = new R();
        return r;
    }
    @ApiOperation("维修经费修改")
    @PutMapping("KeepFunds/updateKeepFunds")
    public R updateKeepFunds(){
        R r = new R();
        return r;
    }
    @ApiOperation("维修经费删除")
    @DeleteMapping("KeepFunds/deleteKeepFunds")
    public R deleteKeepFunds(){
        R r = new R();
        return r;
    }
}

