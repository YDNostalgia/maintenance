package com.gxa.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.gxa.dto.DcountingDto;
import com.gxa.entity.*;
import com.gxa.service.DcountingService;
import com.gxa.utils.R;
import com.gxa.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Api(tags = "盘点库存接口")
@RestController
public class DcountingController {
    @Autowired
    private DcountingService dcountingService;

    @ApiOperation(value = "盘点库存表")
    @PostMapping("/dcounting/list")
    public Result<List<Dcounting>> selectDcounting(@RequestBody(required = false) DcountingDto dcountingDto){
        System.out.println("查询条件" + dcountingDto);
        System.out.println("当前页码：" + dcountingDto.getPage() +",每页记录数：" + dcountingDto.getLimit());

        PageHelper.startPage(dcountingDto.getPage(),dcountingDto.getLimit());

        List<Dcounting> dcountings = this.dcountingService.queryAll(dcountingDto);
        System.out.println("查询结果----->" + dcountings);

        PageInfo<Dcounting> pageInfo = new PageInfo<>(dcountings);
        long total = pageInfo.getTotal();
        System.out.println("total----->" + total);

        Result<List<Dcounting>> r = Result.success(dcountings, total);

        return r;
    }

    @GetMapping("/dcounting/dreview")
    @ApiOperation("审核状态 下拉列表 0:成功 1：失败 2：待审核")
    public Result<List<Dreview>> selectDreviewList(){

        Result<List<Dreview>> resultList = Result.failed("状态信息拉取成功");
        try{
            List<Dreview> dreviews = this.dcountingService.queryAll();
            System.out.println("查询结果----->" + dreviews);

            Integer size = dreviews.size();
            long total = size.longValue();
            System.out.println("total-->" + total);

            resultList = Result.success(dreviews, total);
        } catch (Exception e){
            e.printStackTrace();
        }
        return resultList;
    }

    @PostMapping("/dcounting/perAdd")
    @ApiOperation("盘点库存新增前的查询")
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


    @PostMapping("/dcounting/perEdit")
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
