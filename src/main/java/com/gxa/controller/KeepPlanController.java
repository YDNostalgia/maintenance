package com.gxa.controller;

import com.github.pagehelper.PageInfo;
import com.gxa.dto.KeepPlanDto;
import com.gxa.entity.KeepPlan;
import com.gxa.entity.KeepPlanAU;
import com.gxa.service.KeepPlanService;
import com.gxa.utils.R;
import com.gxa.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@Api(tags = "维修计划接口")
public class KeepPlanController {
    @Autowired
    private KeepPlanService keepPlanService;

    @ApiOperation("维修计划查询")
    @PostMapping("keepPlan/queryAllKeepPlan")
    public Result<List<KeepPlan>> queryAllKeepPlan(@RequestBody(required = false) KeepPlanDto keepPlanDto,Integer page,Integer limit){
        System.out.println(page+"---------"+limit);
        Result<List<KeepPlan>> r = Result.success();
        try{
            System.out.println("keepPlanlist----------"+keepPlanDto);
            PageInfo<KeepPlan> pageInfo = keepPlanService.queryAllKeepPlan(keepPlanDto, page, limit);
            r = Result.success(pageInfo.getList(),pageInfo.getTotal());
        }catch (Exception e){
            e.printStackTrace();
            Result.failed();
        }
        return r;
    }

    @ApiOperation("维修计划添加")
    @PostMapping("/keepPlan/addKeepPlan")
    public Result<List<KeepPlanAU>> addKeepPlan(@RequestBody(required = false) KeepPlanAU keepPlanAU){
        Result<List<KeepPlanAU>> r = Result.success();
        try {
            System.out.println("keepPlanAUadd-----"+keepPlanAU);
            keepPlanService.addKeepPlan(keepPlanAU);
        }catch (Exception e){
            e.printStackTrace();
           Result.success();
        }
        return r;
    }

    @ApiOperation("维修计划修改")
    @PutMapping("/keepPlan/updateKeepPlan")
    public Result<List<KeepPlanAU>> updateKeepPlan(@RequestBody(required = false) KeepPlanAU keepPlanAU){
        System.out.println("KeepPlanAUupdate----------"+keepPlanAU);
        Result<List<KeepPlanAU>> r = Result.success();
        try {
            keepPlanService.updateKeepPlan(keepPlanAU);
        }catch (Exception e){
            e.printStackTrace();
            Result.failed();
        }
        return r;
    }

    @ApiOperation("维修计划删除")
    @DeleteMapping("/keepPlan/deleteKeepPlan")
    @ResponseBody
    public Result<Integer> deleteKeepPlan(@RequestParam("id") int id){
        System.out.println("keepPlan4444id----------"+id);
        Result<Integer> r = Result.success();
        try {
            keepPlanService.deleteKeepPlan(id);
        }catch (Exception e){
            e.printStackTrace();
            r = Result.failed();
        }
        return r;
    }
}
