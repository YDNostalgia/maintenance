package com.gxa.controller;


import com.gxa.dto.DpickingDto;
import com.gxa.entity.*;
import com.gxa.service.DpickingService;
import com.gxa.utils.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(value = "部门领料")
@RestController
public class DpickingController {

    @Autowired
    private DpickingService dpickingService;

    @GetMapping("/dpicking/list")
    @ApiOperation("部门领料列表")
    public R selectList(@RequestBody(required = false) DpickingDto dpickingDto, @RequestBody DpickingSelect dpickingSelect, @Param("page") Integer page, @Param("limit") Integer limit){
        System.out.println("查询条件" + dpickingDto);
        System.out.println("当前页码：" + page +",每页记录数：" + limit);

        List<Dpicking> dpickings = this.dpickingService.selectList();
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
    @ApiOperation("部门领料新增")
    public R dequipAdd(@RequestBody DpickingToAdd dpickingToAdd){

        R r = new R();
        return r;
    }


    @GetMapping("/dpicking/perEdit")
    @ApiOperation("入库修改页")
    public R toEditPage(@RequestBody DpickingToUpdate dpickingToUpdate){
        R r = new R();
        return r;
    }
    @PutMapping("/dpicking/edit")
    @ApiOperation("部门领料修改")
    public R dequipEdit(@RequestBody DpickingToUpdate dpickingToUpdate){

        R r = new R();
        return r;
    }

    @DeleteMapping("/dpicking/delete")
    @ApiOperation("部门领料删除")
    public R dequipDelete(@RequestBody DpickingDelete dpickingDelete){

        R r = new R();
        return r;
    }
    @DeleteMapping("/dpicking/deletes")
    @ApiOperation("部门领料删除(大量删除)")
    public R dequipDeletes(@RequestBody DequipDeletes DequipDeletes){

        R r = new R();
        return r;
    }
}
