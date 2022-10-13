package com.gxa.controller;

import com.gxa.entity.*;
import com.gxa.service.DcountingService;
import com.gxa.utils.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@ApiModel(value = "盘点库存表")
@RestController
public class DcountingController {
    @Autowired
    private DcountingService dcountingService;

    @ApiOperation(value = "盘点库存表")
    @GetMapping("/dcounting/list")
    public R selectDcounting(@RequestBody(required = false) Dcounting dcountingDto, @RequestBody DcountingSelect dcountingSelect, @Param("page") Integer page, @Param("limit") Integer limit){
        System.out.println("查询条件" + dcountingDto);
        System.out.println("当前页码：" + page +",每页记录数：" + limit);

        List<Dcounting> dcountings = this.dcountingService.queryAll();
        System.out.println(dcountings);

        R r = new R();
        r.put("count",dcountings.size());
        r.put("data",dcountings);

        return r;
    }


    @GetMapping("/dcounting/perAdd")
    @ApiOperation("盘点库存新增页")
    public R toAddPage(@RequestBody DcountingToAdd dcountingToAdd){
        R r = new R();
        return r;
    }
    @PostMapping("/dcounting/add")
    @ApiOperation("盘点库存新增")
    public R dcountingAdd(@RequestBody DcountingToAdd dcountingToAdd){

        R r = new R();
        return r;
    }


    @GetMapping("/dcounting/perEdit")
    @ApiOperation("盘点库存修改页")
    public R toEditPage(@RequestBody DcountingToUpate dcountingToUpate){
        R r = new R();
        return r;
    }
    @PutMapping("/dcounting/edit")
    @ApiOperation("盘点库存修改")
    public R dcountingEdit(@RequestBody DcountingToUpate dcountingToUpate){

        R r = new R();
        return r;
    }

    @DeleteMapping("/dcounting/delete")
    @ApiOperation("盘点库存删除")
    public R dcountingDelete(@RequestBody DcountingDelete dcountingDelete){

        R r = new R();
        return r;
    }
    @DeleteMapping("/dcounting/deletes")
    @ApiOperation("盘点库存删除")
    public R dcountingDeletes(@RequestBody DcountingDeletes dcountingDeletes){

        R r = new R();
        return r;
    }
}
