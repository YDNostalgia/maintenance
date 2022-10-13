package com.gxa.controller;

import com.gxa.entity.*;
import com.gxa.service.DreturnService;
import com.gxa.utils.R;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@ApiModel(value = "部门退料表")
@RestController
public class DreturnController {
    @Autowired
    private DreturnService dreturnService;

    @ApiOperation(value = "部门退料表")
    @GetMapping("/dreturn/list")
    public R selectDreturn(@RequestBody(required = false) Dreturn dreturnDto, @RequestBody DreturnSelect dreturnSelect, @Param("page") Integer page, @Param("limit") Integer limit){
        System.out.println("查询条件" + dreturnDto);
        System.out.println("当前页码：" + page +",每页记录数：" + limit);

        List<Dreturn> dreturns = this.dreturnService.queryAll();
        System.out.println(dreturns);

        R r = new R();
        r.put("count",dreturns.size());
        r.put("data",dreturns);

        return r;
    }


    @GetMapping("/dreturn/perAdd")
    @ApiOperation("部门退料新增页")
    public R toAddPage(DreturnToAdd dreturnToAdd){
        R r = new R();
        return r;
    }
    @PostMapping("/dreturn/add")
    @ApiOperation("退料新增")
    public R dreturnAdd(@RequestBody Dreturn dreturn){

        R r = new R();
        return r;
    }


    @GetMapping("/dreturn/perEdit")
    @ApiOperation("退料修改页")
    public R toEditPage(DreturnToupdate dreturnToupdate){
        R r = new R();
        return r;
    }
    @PutMapping("/dreturn/edit")
    @ApiOperation("退料修改")
    public R dreturnEdit(@RequestBody DreturnToupdate dreturnToupdate){

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
