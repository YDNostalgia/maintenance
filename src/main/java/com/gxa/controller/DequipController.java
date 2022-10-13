package com.gxa.controller;

import com.gxa.dto.DequipDto;
import com.gxa.entity.*;
import com.gxa.service.DequipService;
import com.gxa.utils.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(value = "器材管理")
@RestController
public class DequipController {

    @Autowired
    private DequipService dequipService;


    @GetMapping("/dequip/list")
    @ApiOperation("器材管理列表")
    public R selectDequip(@RequestBody(required = false)DequipDto dequipDto, @RequestBody DequipSelect dequipSelect, @Param("page") Integer page, @Param("limit") Integer limit){
        System.out.println("查询条件" + dequipDto);
        System.out.println("当前页码：" + page +",每页记录数：" + limit);

        List<Dequip> dequips = this.dequipService.queryDequips();
        System.out.println(dequips);

        R r = new R();
        r.put("count",dequips.size());
        r.put("data",dequips);

        return r;
    }


    @GetMapping("/dequip/perAdd")
    @ApiOperation("器材新增页")
    public R toAddPage(@RequestBody DequipToAdd dequipToAdd){
        R r = new R();
        return r;
    }
    @PostMapping("/dequip/add")
    @ApiOperation("器材新增")
    public R dequipAdd(@RequestBody DequipToAdd dequipToAdd){

        R r = new R();
        return r;
    }


    @GetMapping("/dequip/perEdit")
    @ApiOperation("器材修改页")
    public R toEditPage(@RequestBody DequipToUpdate dequipToUpdate){
        R r = new R();
        return r;
    }
    @PutMapping("/dequip/edit")
    @ApiOperation("器材修改")
    public R dequipEdit(@RequestBody DequipToUpdate dequipToUpdate){

        R r = new R();
        return r;
    }

    @DeleteMapping("/dequip/delete")
    @ApiOperation("器材修改")
    public R dequipDelete(@RequestBody DequipDelete dequipDelete){

        R r = new R();
        return r;
    }
    @DeleteMapping("/dequip/deletes")
    @ApiOperation("器材修改")
    public R dequipDeletes(@RequestBody DequipDelete dequipDelete){

        R r = new R();
        return r;
    }
}
