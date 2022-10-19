package com.gxa.controller;

import com.gxa.entity.KeepStaute;
import com.gxa.service.KeepStauteSerivce;
import com.gxa.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Api(tags = "维修状态接口")
public class KeepStauteController {
    @Autowired
    private KeepStauteSerivce keepStauteSerivce;

    @ApiOperation("维修状态查询")
    @PostMapping("keepPlan/queryAllStaute")
    public Result<List<KeepStaute>> queryAllStaute(){
        Result<List<KeepStaute>> r = Result.success();
        try {
            List<KeepStaute> keepStautes = keepStauteSerivce.queryAllKeepStaute();
            r = Result.success(keepStautes);
        }catch (Exception e){
            e.printStackTrace();
            r = Result.failed();
        }
        return r;
    }
}
