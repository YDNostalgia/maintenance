package com.gxa.controller;

import com.github.pagehelper.PageInfo;
import com.gxa.dto.WAccountDetailsQueryDto;
import com.gxa.dto.WPickingManagementAddDto;
import com.gxa.dto.WPickingManagementQueryDto;
import com.gxa.entity.WAccountDetails;
import com.gxa.entity.WPickingManagement;
import com.gxa.service.WAccountDetailsService;
import com.gxa.service.WPickingManagementService;
import com.gxa.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Api(tags = "台账明细")
public class WAccountDetailsController {

    @Autowired
    private WAccountDetailsService wAccountDetailsService;
    @ApiOperation("查询库存信息")
    @PostMapping("/WAccountDetails/list")
    public Result<WAccountDetails> list(@RequestBody WAccountDetailsQueryDto wAccountDetailsQueryDto){

        Result<WAccountDetails> r = Result.failed();
        WAccountDetails wAccountDetails = wAccountDetailsService.queryByCondition(wAccountDetailsQueryDto);
        if (wAccountDetails != null){
            r = Result.success(wAccountDetails);
            return r;
        }
        return r;
    }

    @ApiOperation("查询某个器材的库存批次号")
    @GetMapping("/WAccountDetails/list")
    public Result<List<Integer>> list(@ApiParam(value = "器材编号",name = "wfacilityManagementId",required = true) Integer wfacilityManagementId,
                                      @ApiParam(value = "查询状态（1：查询所有库存批次号，2：查询库存不为0的批次号）",name = "code",required = true) Integer code){

        Result<List<Integer>> r = Result.failed();
        List<Integer> wfacilityManagementIds = wAccountDetailsService.queryByWfacilityManagementId(wfacilityManagementId,code);
        if (wfacilityManagementIds != null){
            r = Result.success(wfacilityManagementIds);
            return r;
        }
        return r;
    }

}
