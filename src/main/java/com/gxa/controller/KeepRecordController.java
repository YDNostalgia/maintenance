package com.gxa.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.gxa.dto.KeepPlanDto;
import com.gxa.dto.KeepRecordDto;
import com.gxa.entity.KeepPlan;
import com.gxa.entity.KeepRecord;
import com.gxa.service.KeepRecordService;
import com.gxa.utils.R;
import com.gxa.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api("维修记录接口")
public class KeepRecordController {
    @Autowired
    private KeepRecordService keepRecordService;
    @ApiOperation("维修记录查询")
    @PostMapping("keepRecord/queryAllRecord")
    public Result<List<KeepRecord>> queryAllkeepRecord(KeepRecordDto keepRecordDto,Integer page,Integer limit){
        System.out.println("keepRecordDto-->" + keepRecordDto);
        System.out.println(page+  "----"+ limit);
        Result<List<KeepRecord>> r = Result.success();
            try{
               PageInfo pageInfo = keepRecordService.queryAllKeepRecord(keepRecordDto,page,limit);
                System.out.println("查询出的数据:" + pageInfo.getList());
                r = Result.success(pageInfo.getList(), pageInfo.getTotal());
                System.out.println("total---------"+pageInfo.getTotal());
            }catch (Exception e){
                e.printStackTrace();
                r = Result.failed();
            }
            return r;
        }
    @ApiOperation("维修记录添加")
    @PostMapping("keepRecord/addRecord")
    public Result<List<KeepRecord>> addkeepRecord(KeepRecord keepRecord){
        System.out.println("add-----------"+keepRecord);
        Result<List<KeepRecord>> r = Result.success();
        try {
            keepRecordService.addKeepRecord(keepRecord);
        }catch (Exception e){
            e.printStackTrace();
            Result.failed();
        }
        return r;
    }
    @ApiOperation("维修记录修改")
    @PutMapping("keepRecord/updateRecord")
    public Result<Integer> updatekeepRecord(KeepRecord keepRecord){
        System.out.println("update---------"+keepRecord);
        Result<Integer> r = Result.success();
        try {
            keepRecordService.updateKeepRecord(keepRecord);
        }catch (Exception e){
            e.printStackTrace();
            Result.failed();
        }
        return r;
    }
    @ApiOperation("维修记录删除")
    @DeleteMapping("keepRecord/deleteRecord")
    public Result<Integer> deleteRecord(@RequestParam("id") Integer id){
        System.out.println("delete---------"+id);
        Result<Integer> r = Result.success();
        try {
            keepRecordService.deleteKeepRecord(id);
        }catch (Exception e){
            e.printStackTrace();
            Result.failed();
        }
        return r;
    }
}
