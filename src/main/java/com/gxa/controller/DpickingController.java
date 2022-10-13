package com.gxa.controller;

import com.gxa.entity.*;
import com.gxa.service.DpickingService;
import com.gxa.utils.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Api(value = "部门领料表")
@RestController
public class DpickingController {

    @Autowired
    private DpickingService dpickingService;

    @ApiOperation(value = "部门领料表")
    @GetMapping("/dpicking/list")
    public R selectDpicking(@RequestBody(required = false) Dpicking dpickingDto,@RequestBody DpickingSelect dpickingSelect, @Param("page") Integer page, @Param("limit") Integer limit){
        System.out.println("查询条件" + dpickingDto);
        System.out.println("当前页码：" + page +",每页记录数：" + limit);

        List<Dpicking> dpickings = this.dpickingService.queryAll();
        System.out.println(dpickings);

        R r = new R();
        r.put("count",dpickings.size());
        r.put("data",dpickings);

        return r;
    }


    @GetMapping("/dpicking/perAdd")
    @ApiOperation("部门领料新增页")
    public R toAddPage(@RequestBody DpickingToAdd dpickingToAdd){
        R r = new R();
        return r;
    }
    @PostMapping("/dpicking/add")
    @ApiOperation("领料新增")
    public R dpickingAdd(@RequestBody DpickingToAdd dpickingToAdd){

        R r = new R();
        return r;
    }


    @GetMapping("/dpicking/perEdit")
    @ApiOperation("领料修改页")
    public R toEditPage(@RequestBody DpickingToUpdate dpickingToupdate){
        R r = new R();
        return r;
    }
    @PutMapping("/dpicking/edit")
    @ApiOperation("领料修改")
    public R dpickingEdit(@RequestBody DpickingToUpdate dpickingToupdate){

        R r = new R();
        return r;
    }

    @DeleteMapping("/dpicking/delete")
    @ApiOperation("领料删除")
    public R dpickingDelete(@RequestBody DpickingDelete dpickingDelete){

        R r = new R();
        return r;
    }
    @DeleteMapping("/dpicking/deletes")
    @ApiOperation("领料删除")
    public R dpickingDeletes(@RequestBody DpickingDeletes dpickingDeletes){

        R r = new R();
        return r;
    }

}
