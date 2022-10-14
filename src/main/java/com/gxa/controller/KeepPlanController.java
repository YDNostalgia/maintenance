package com.gxa.controller;

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
@Api("维修计划接口")
public class KeepPlanController {
    @Autowired
    private KeepPlanService keepPlanService;

    @ApiOperation("维修计划查询")
    @GetMapping("/keepPlan/queryAllKeepPlan")
    public Result<List<KeepPlan>> queryAllKeepPlan(KeepPlanDto keepPlanDto){
        Result<List<KeepPlan>> r = Result.success();
        try{
            System.out.println("keepPlanlist----------"+keepPlanDto);
            List<KeepPlan> keepPlans = keepPlanService.queryAllKeepPlan(keepPlanDto);
            System.out.println("keepPlans---------"+keepPlans);
            long count = keepPlanService.count(keepPlanDto);
            r=Result.success(keepPlans,count);
            return r;
        }catch (Exception e){
            e.printStackTrace();
            r.setCode("11111");
            r.setMsg("异常出错");
        }
        return r;
    }

    @ApiOperation("维修计划添加")
    @PostMapping("/keepPlan/addKeepPlan")
    public R addKeepPlan(KeepPlanAU keepPlanAU){
        R r = new R();
        try {
            keepPlanService.addKeepPlan(keepPlanAU);
            r = R.ok();
        }catch (Exception e){
            e.printStackTrace();
            r = R.error(1,"添加失败");
        }
        return r;
    }

    @ApiOperation("维修计划修改")
    @PutMapping("/keepPlan/updateKeepPlan")
    public R updateKeepPlan(KeepPlanAU keepPlanAU){
        System.out.println("KeepPlanAU----------"+keepPlanAU);
        R r = new R();
        try {
            keepPlanService.updateKeepPlan(keepPlanAU);
            r = R.ok();
        }catch (Exception e){
            e.printStackTrace();
            r = R.error(1,"修改失败");
        }
        return r;
    }

    @ApiOperation("维修计划删除")
    @DeleteMapping("/keepPlan/deleteKeepPlan")
    @ResponseBody
    public R deleteKeepPlan(@RequestParam("id") int id){
        System.out.println("keepPlan4444id----------"+id);
        R r = new R();
        r = R.ok();
        try {
            keepPlanService.deleteKeepPlan(id);
        }catch (Exception e){
            e.printStackTrace();
            r = R.error(1,"删除失败");
        }
        return r;
    }


}
