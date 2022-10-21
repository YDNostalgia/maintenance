package com.gxa.controller;

import com.gxa.dto.KeepProcessDto;
import com.gxa.entity.KeepProcess;
import com.gxa.service.KeepProcessService;
import com.gxa.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Api(tags = "维修记录--记录详情--维修过程 接口")
public class KeepProcessContrller {
    @Autowired
    private KeepProcessService keepProcessService;

    @ApiOperation("维修记录--记录详情--维修过程 查询")
    @PostMapping("KeepProcess/queryByKeepId")
    public Result<List<KeepProcess>> queryByKeepId(Integer keepId){
        System.out.println("list keepId-------->" + keepId);
        Result<List<KeepProcess>> r = Result.success();
        try{
            List<KeepProcess> keepProcesses = keepProcessService.queryByKeepId(keepId);
            r = Result.success(keepProcesses);
        }catch (Exception e){
            e.printStackTrace();
            r = Result.failed();
        }
        return r;
    }

        @ApiOperation("维修记录添加")
    @PostMapping("KeepProcess/addKeepProcess")
    public Result<List<KeepProcess>> addKeepProcess(@RequestBody(required = false) KeepProcessDto keepProcessDto){
        System.out.println("add-----------"+keepProcessDto);
        Result<List<KeepProcess>> r = Result.success();
        try {
            keepProcessService.addKeepProcess(keepProcessDto);
        }catch (Exception e){
            e.printStackTrace();
            r = Result.failed();
        }
        return r;
    }
}
