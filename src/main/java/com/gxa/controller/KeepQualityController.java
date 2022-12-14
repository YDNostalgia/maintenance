package com.gxa.controller;

import com.github.pagehelper.PageInfo;
import com.gxa.dto.KeepPlanDto;
import com.gxa.entity.KeepQuality;
import com.gxa.entity.KeepQualityAU;
import com.gxa.entity.KeepRecord;
import com.gxa.service.KeepQualityService;
import com.gxa.utils.R;
import com.gxa.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.omg.CORBA.TRANSACTION_MODE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(tags = "维修质量接口")
public class KeepQualityController {
    @Autowired
    private KeepQualityService keepQualityService;

    @ApiOperation("维修质量查询")
    @PostMapping("/KeepQuality/queryAllKeepQuality")
    public Result<List<KeepQuality>> queryAllKeepQuality(@RequestBody(required = false) KeepPlanDto keepPlanDto,Integer page,Integer limit){
        System.out.println("keepPlanDto-->" + keepPlanDto);
        System.out.println(page+  "----"+ limit);
        Result<List<KeepQuality>> r = Result.success();
        try {
            PageInfo<KeepQuality> pageInfo = keepQualityService.queryAllKeepQuality(keepPlanDto, page, limit);
            r = Result.success(pageInfo.getList(),pageInfo.getTotal());
        }catch (Exception e){
            e.printStackTrace();
            r = Result.failed();
        }
        return r;
    }
//    @ApiOperation("维修质量添加")
//    @PostMapping("KeepQuality/addKeepQuality")
//    public Result<Integer> addKeepQuality(@RequestBody(required = false) KeepQualityAU keepQualityAU){
//        System.out.println("adddd-->" + keepQualityAU);
//        Result<Integer> r = Result.success();
//        try {
//            keepQualityService.addKeepQuality(keepQualityAU);
//        }catch (Exception e){
//            e.printStackTrace();
//            r = Result.failed();
//        }
//        return r;
//    }
    @ApiOperation("维修质量修改")
    @PutMapping("/KeepQuality/update")
    public Result<Integer> updateKeepQuality(@RequestBody(required = false) KeepQualityAU keepQualityAU){
        System.out.println("adddd-->" + keepQualityAU);
        Result<Integer> r = Result.success();
        try {
            keepQualityService.updateKeepQuality(keepQualityAU);
        }catch (Exception e){
            e.printStackTrace();
            r = Result.failed();
        }
        return r;
    }
    @ApiOperation("维修质量删除")
    @DeleteMapping("/KeepQuality/delete")
    public Result<Integer> deleteKeepQuality(@RequestParam("id") Integer id){
        System.out.println("delete-->" + id);
        Result<Integer> r = Result.success();
        try {
            keepQualityService.deleteKeepQuality(id);
        }catch (Exception e){
            e.printStackTrace();
            r = Result.failed();
        }
        return r;
    }
}
