package com.gxa.controller;

import com.github.pagehelper.PageInfo;
import com.gxa.dto.KeepPlanDto;
import com.gxa.entity.KeepFunds;
import com.gxa.entity.KeepFundsAU;
import com.gxa.service.KeepFundsService;
import com.gxa.utils.R;
import com.gxa.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api("维修经费接口")
public class KeepFundsContrlloer {
    @Autowired
    private KeepFundsService keepFundsService;
    @ApiOperation("维修经费查询")
    @PostMapping("KeepFunds/queryAllKeepFunds")
    public Result<List<KeepFunds>> queryAllKeepFunds(@RequestBody(required = false) KeepPlanDto keepPlanDto,Integer page,Integer limit){
        System.out.println("List-->" + keepPlanDto);
        System.out.println(page+  "----"+ limit);
        Result<List<KeepFunds>> r = Result.success();
        try {
            PageInfo<KeepFunds> pageInfo = keepFundsService.queryAllKeepFunds(keepPlanDto, page, limit);
            r = Result.success(pageInfo.getList(),pageInfo.getTotal());
        }catch (Exception e){
            e.printStackTrace();
            r = Result.failed();
        }
        return r;
    }
    @ApiOperation("维修经费添加")
    @PostMapping("KeepFunds/addKeepFunds")
    public Result<List<KeepFunds>> addKeepFunds(@RequestBody(required = false) KeepFundsAU keepFundsAU){
        System.out.println("add-->" + keepFundsAU);
        Result<List<KeepFunds>> r = Result.success();

        try {
            keepFundsService.addKeepFunds(keepFundsAU);
        }catch (Exception e){
            e.printStackTrace();
            r= Result.failed();
        }
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

