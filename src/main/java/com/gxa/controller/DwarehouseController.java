package com.gxa.controller;

import com.gxa.dto.DwarehouseDto;
import com.gxa.entity.*;
import com.gxa.service.DwarehouseService;
import com.gxa.utils.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(value = "入库管理")
@RestController
public class DwarehouseController {

    @Autowired
    private DwarehouseService dwarehouseService;

    @GetMapping("/dwarehouse/list")
    @ApiOperation("入库管理列表")
    public R selectDarehouses(@RequestBody(required = false)DwarehouseDto dwarehouseDto, @RequestBody DwarehouseSelect dwarehouseSelect,@Param("page") Integer page, @Param("limit") Integer limit){
        System.out.println("查询条件" + dwarehouseDto);
        System.out.println("当前页码：" + page +",每页记录数：" + limit);

        List<Dwarehouse> dwarehouses = this.dwarehouseService.queryDwarehouse();
        System.out.println(dwarehouses);

        R r = new R();
        r.put("count",dwarehouses.size());
        r.put("data",dwarehouses);

        return r;
    }

    @GetMapping("/dwarehouse/perAdd")
    @ApiOperation("入库新增页")
    public R toAddPage(@RequestBody DwarehouseToAdd dwarehouseToAdd){
        R r = new R();
        return r;
    }
    @PostMapping("/dwarehouse/add")
    @ApiOperation("入库新增")
    public R dequipAdd(@RequestBody DwarehouseToAdd dwarehouseToAdd){

        R r = new R();
        return r;
    }


    @GetMapping("/dwarehouse/perEdit")
    @ApiOperation("入库修改页")
    public R toEditPage(@RequestBody DwarehouseToUpdate dwarehouseToUpdate){
        R r = new R();
        return r;
    }
    @PutMapping("/dwarehouse/edit")
    @ApiOperation("入库修改")
    public R dequipEdit(@RequestBody DwarehouseToUpdate dwarehouseToUpdate){

        R r = new R();
        return r;
    }

    @DeleteMapping("/dwarehouse/delete")
    @ApiOperation("入库删除")
    public R dequipDelete(@RequestBody DwarehouseDelete dwarehouseDelete){

        R r = new R();
        return r;
    }
    @DeleteMapping("/dwarehouse/deletes")
    @ApiOperation("入库删除(大量删除)")
    public R dequipDeletes(@RequestBody DwarehouseDeletes dwarehouseDeletes){

        R r = new R();
        return r;
    }
}
