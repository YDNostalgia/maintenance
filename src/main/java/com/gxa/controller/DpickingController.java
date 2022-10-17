package com.gxa.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.gxa.dto.DpickingDto;
import com.gxa.entity.*;
import com.gxa.service.DpickingService;
import com.gxa.utils.R;
import com.gxa.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Api(tags = "部门领料接口")
@RestController
public class DpickingController {

    @Autowired
    private DpickingService dpickingService;

    @ApiOperation(value = "部门领料表")
    @PostMapping("/dpicking/list")
    public Result<List<Dpicking>> selectDpicking(@RequestBody(required = false) DpickingDto dpickingDto, @Param("page") Integer page, @Param("limit") Integer limit){
        System.out.println("查询条件" + dpickingDto);
        System.out.println("当前页码：" + page +",每页记录数：" + limit);

        PageHelper.startPage(page,limit);

        List<Dpicking> dpickings = this.dpickingService.queryAll(dpickingDto);
        System.out.println("查询结果----->" + dpickings);

        PageInfo<Dpicking> pageInfo = new PageInfo<>(dpickings);
        long total = pageInfo.getTotal();
        System.out.println("total----->" + total);

        Result<List<Dpicking>> r = Result.success(dpickings, total);

        return r;
    }


    @PostMapping("/dpicking/perAdd")
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


    @PostMapping("/dpicking/perEdit")
    @ApiOperation("领料修改页")
    public R toEditPage(@RequestBody DpickingToUpdate dpickingToupdate){
        R r = new R();
        return r;
    }
    @PostMapping("/dpicking/edit")
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
    public R dpickingDeletes(Integer id){
        System.out.println(id);

        if(id!=null){
            R r=R.ok("领料删除成功！");
            return r;
        }else {
            R r=R.error("领料删除失败！");
            return r;
        }
    }

}
