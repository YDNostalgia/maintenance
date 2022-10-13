package com.gxa.controller;

import com.gxa.dto.DreturnDto;
import com.gxa.entity.*;
import com.gxa.service.DreturnService;
import com.gxa.utils.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(value = "部门推料")
@RestController
public class DreturnController {

    @Autowired
    private DreturnService dreturnService;

    @GetMapping("/dreturn/list")
    @ApiOperation("部门推料列表")
    public R selectList(@RequestBody(required = false) DreturnDto dreturnDto, @RequestBody DreturnSelect dreturnSelect, @Param("page") Integer page, @Param("limit") Integer limit){
        System.out.println("查询条件" + dreturnDto);
        System.out.println("当前页码：" + page +",每页记录数：" + limit);

        List<Dreturn> dreturns = this.dreturnService.selectList();
        System.out.println(dreturns);

        R r = new R();
        r.put("count",dreturns.size());
        r.put("data",dreturns);

        return r;
    }

    @GetMapping("/dreturn/perAdd")
    @ApiOperation("部门推料新增页")
    public R toAddPage(@RequestBody DreturnToAdd dreturnToAdd){
        R r = new R();
        return r;
    }
    @PostMapping("/dreturn/add")
    @ApiOperation("部门推料新增")
    public R dequipAdd(@RequestBody DreturnToAdd dreturnToAdd){

        R r = new R();
        return r;
    }


    @GetMapping("/dreturn/perEdit")
    @ApiOperation("部门推料修改页")
    public R toEditPage(@RequestBody DreturnToUpdate dreturnToUpdate){
        R r = new R();
        return r;
    }
    @PutMapping("/dreturn/edit")
    @ApiOperation("部门推料修改")
    public R dequipEdit(@RequestBody DreturnToUpdate dreturnToUpdate){

        R r = new R();
        return r;
    }

    @DeleteMapping("/dreturn/delete")
    @ApiOperation("部门推料删除")
    public R dequipDelete(@RequestBody DreturnDelete dreturnDelete){

        R r = new R();
        return r;
    }
    @DeleteMapping("/dreturn/deletes")
    @ApiOperation("部门退料删除(大量删除)")
    public R dequipDeletes(@RequestBody DreturnDeletes dreturnDeletes){

        R r = new R();
        return r;
    }
}
