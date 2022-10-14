package com.gxa.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.gxa.dto.DreturnDto;
import com.gxa.entity.*;
import com.gxa.service.DreturnService;
import com.gxa.utils.R;
import com.gxa.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Api(tags = "部门退料接口")
@RestController
public class DreturnController {
    @Autowired
    private DreturnService dreturnService;

    @ApiOperation(value = "部门退料表")
    @PostMapping("/dreturn/list")
    public Result<List<Dreturn>> selectDreturn(@RequestBody(required = false) DreturnDto dreturnDto, @Param("page") Integer page, @Param("limit") Integer limit){
        System.out.println("查询条件" + dreturnDto);
        System.out.println("当前页码：" + page +",每页记录数：" + limit);

        PageHelper.startPage(page,limit);

        List<Dreturn> dreturns = this.dreturnService.queryAll(dreturnDto);
        System.out.println("查询结果----->" + dreturns);

        PageInfo<Dreturn> pageInfo = new PageInfo<>(dreturns);
        long total = pageInfo.getTotal();
        System.out.println("total----->" + total);

        Result<List<Dreturn>> r = Result.success(dreturns, total);

        return r;
    }


    @PostMapping("/dreturn/perAdd")
    @ApiOperation("部门退料新增页")
    public R toAddPage(DreturnToAdd dreturnToAdd){
        R r = new R();
        return r;
    }
    @PutMapping("/dreturn/add")
    @ApiOperation("退料新增")
    public R dreturnAdd(@RequestBody Dreturn dreturn){

        R r = new R();
        return r;
    }


    @PostMapping("/dreturn/perEdit")
    @ApiOperation("退料修改页")
    public R toEditPage(DreturnToUpdate dreturnToupdate){
        R r = new R();
        return r;
    }
    @PutMapping("/dreturn/edit")
    @ApiOperation("退料修改")
    public R dreturnEdit(@RequestBody DreturnToUpdate dreturnToupdate){

        R r = new R();
        return r;
    }

    @DeleteMapping("/dreturn/delete")
    @ApiOperation("退料删除")
    public R dreturnDelete(@RequestBody DreturnDelete dreturnDelete){

        R r = new R();
        return r;
    }
    @DeleteMapping("/dreturn/deletes")
    @ApiOperation("退料删除")
    public R dreturnDeletes(@RequestBody DreturnDeletes dreturnDeletes){

        R r = new R();
        return r;
    }
}
