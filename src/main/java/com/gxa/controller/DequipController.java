package com.gxa.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.gxa.dto.DequipDto;
import com.gxa.entity.*;
import com.gxa.service.DequipService;
import com.gxa.utils.R;
import com.gxa.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "器材管理接口")
@RestController
public class DequipController {

    @Autowired
    private DequipService dequipService;


    @PostMapping("/dequip/list")
    @ApiOperation("器材管理列表")
    public Result<List<Dequip>> selectList(@RequestBody(required = false) DequipDto dequipDto, @Param("page") Integer page, @Param("limit") Integer limit){
        System.out.println("查询条件----->" + dequipDto);
        System.out.println("当前页码----->" + page + ",每页数据---->" + limit);

        PageHelper.startPage(page,limit);

        List<Dequip> dequips = this.dequipService.queryChooseList(dequipDto);
        System.out.println("查询结果----->" + dequips);

        PageInfo<Dequip> pageInfo = new PageInfo<>(dequips);
        long total = pageInfo.getTotal();
        System.out.println("total----->" + total);

        Result<List<Dequip>> r = Result.success(dequips, total);

        return r;
    }


    @PostMapping("/dequip/perAdd")
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
    public R dequipDeletes(@RequestBody DequipDeletes DequipDeletes){

        R r = new R();
        return r;
    }
}
