package com.gxa.controller;

import com.gxa.entity.KeepPersonPerfor;
import com.gxa.mapper.KeepPersonPerforMapper;
import com.gxa.service.KeepPersonPerforService;
import com.gxa.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Api(tags = "数据统计---维修人员绩效 接口")
public class KeepPersonPerforController {
    @Autowired
    private KeepPersonPerforService keepPersonPerforService;

    @ApiOperation("数据统计---维修人员绩效 查询")
    @PostMapping("/KeepPersonPerfor/queryKeepPersonPerfor")
    public Result<List<KeepPersonPerfor>> queryKeepPersonPerfor(){

        Result<List<KeepPersonPerfor>> r = Result.failed();
        try {
            List<KeepPersonPerfor> keepPersonPerfors = keepPersonPerforService.queryKeepPersonPerfor();
            r = Result.success(keepPersonPerfors);
        }catch (Exception e){
            e.printStackTrace();
            r = Result.failed();
        }
        return r;
    }
}
