package com.gxa.controller;

import com.github.pagehelper.PageInfo;
import com.gxa.dto.KeepPlanDto;
import com.gxa.entity.KeepFile;
import com.gxa.entity.KeepFileAU;
import com.gxa.entity.KeepRecord;
import com.gxa.service.KeepFileService;
import com.gxa.utils.R;
import com.gxa.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.ExecutionException;

@RestController
@Api(tags = "维修档案接口")
public class KeepFileContrller {
    @Autowired
    private KeepFileService keepFileService;
    @ApiOperation("维修档案查询")
    @PostMapping("/keepFile/queryAllkeepFile")
    public Result<List<KeepFile>> queryAllkeepFile(@RequestBody(required = false) KeepPlanDto keepPlanDto,Integer page,Integer limit){
        System.out.println("select--------"+keepPlanDto);
        System.out.println(page+"----页面----"+limit);
        Result<List<KeepFile>> r = Result.success();
        try {
            PageInfo<KeepFile> pageInfo = keepFileService.queryAllKeepFile(keepPlanDto,page,limit);
            r = Result.success(pageInfo.getList(),pageInfo.getTotal());
        }catch (Exception e){
            e.printStackTrace();
            r = Result.failed();
        }
        return r;
    }
//    @ApiOperation("维修档案添加")
//    @PostMapping("keepFile/addkeepFile")
//    public Result<Integer> addkeepFile(@RequestBody(required = false) KeepFileAU keepFileAU){
//        System.out.println("add"+keepFileAU);
//        Result<Integer> r = Result.success();
//        try {
//            keepFileService.addKeepFile(keepFileAU);
//        }catch (Exception e){
//            e.printStackTrace();
//            r = Result.failed();
//        }
//        return r;
//    }
    @ApiOperation("维修档案修改")
    @PutMapping("/keepFile/update")
    public Result<Integer> updatekeepFile(@RequestBody(required = false) KeepFileAU keepFileAU){
        System.out.println("update---------"+keepFileAU);
        Result<Integer> r = Result.success();
        try {
            keepFileService.updateKeepFile(keepFileAU);
        }catch (Exception e){
            e.printStackTrace();
            r = Result.failed();
        }
        return r;
    }
    @ApiOperation("维修档案删除")
    @DeleteMapping("/keepFile/delete")
    public Result<Integer> deletekeepFile(@RequestParam("id") Integer id){
            System.out.println("delete---------"+id);
            Result<Integer> r = Result.success();
            try {
                keepFileService.deleteKeepFile(id);
            }catch (Exception e){
                e.printStackTrace();
                r = Result.failed();
            }
            return r;
        }
}
