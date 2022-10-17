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

        //实现分页
        PageHelper.startPage(page,limit);

        List<Dequip> dequips = this.dequipService.queryChooseList(dequipDto);
        System.out.println("查询结果----->" + dequips);

        //获取总记录数
        PageInfo<Dequip> pageInfo = new PageInfo<>(dequips);
        Long total = pageInfo.getTotal();
        System.out.println("total----->" + total);

        Result<List<Dequip>> r = Result.success(dequips, total);

        return r;
    }
    @GetMapping("/dequip/dtype")
    @ApiOperation("器材分类 下拉列表")
    public Result<List<Detype>> selectTypeList(){
        List<Detype> detypes = this.dequipService.queryType();
        System.out.println("查询结果----->" + detypes);

        //查询总记录数
        Integer size = detypes.size();
        Long total = size.longValue();
        System.out.println("total-->" + total);

        Result<List<Detype>> r = Result.success(detypes, total);

        return r;
    }
    @GetMapping("/dequip/dsave")
    @ApiOperation("存放区域 下拉列表")
    public Result<List<Desave>> delectSaveList(){
        List<Desave> desaves = this.dequipService.querySave();
        System.out.println("查询结果----->" + desaves);

        Integer size = desaves.size();
        long total = size.longValue();
        System.out.println("total-->" + total);

        Result<List<Desave>> r = Result.success(desaves, total);
        return r;
    }

    @GetMapping("/dequip/dcompany")
    @ApiOperation("单位 下拉列表")
    public Result<List<Decompany>> delectCompanyList(){
        List<Decompany> decompanies = this.dequipService.queryCompany();
        System.out.println("查询结果----->" + decompanies);

        Integer size = decompanies.size();
        long total = size.longValue();
        System.out.println("total-->" + total);

        Result<List<Decompany>> r = Result.success(decompanies, total);
        return r;
    }


    @PostMapping("/dequip/add")
    @ApiOperation("器材新增")
    public R addDequip(@RequestBody DequipToAdd dequipToAdd){
        System.out.println("添加数据——>" + dequipToAdd);

        DequipToAdd queryAdd = this.dequipService.addDequip(dequipToAdd);

        if(queryAdd != null){
            R r = R.ok("添加成功");
            return r;
        } else {
            R r = R.error(1,"添加失败,请重新添加");
            return r;
        }
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
