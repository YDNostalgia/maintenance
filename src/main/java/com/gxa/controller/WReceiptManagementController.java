package com.gxa.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.gxa.dto.*;
import com.gxa.entity.WReceiptDetails;
import com.gxa.entity.WReceiptManagement;
import com.gxa.service.WReceiptManagementService;
import com.gxa.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(tags = "入库管理")
@RestController
public class WReceiptManagementController {

    @Autowired
    private WReceiptManagementService wReceiptManagementService;

    @ApiOperation(value = "审核状态 下拉列表(1.待审核，2.审核通过，3.审核拒绝)")
    @PostMapping(value = "/wReceiptManagement/status")
    public Result<List<WReceiptManagementStatusDto>> selectByStatus(){
        Result<List<WReceiptManagementStatusDto>> listResult = Result.failed("审核状态获取失败");

        try{
            List<WReceiptManagementStatusDto> wReceiptManagementStatusDtos = this.wReceiptManagementService.queryByStatus();
            System.out.println("查询记录数————>" + wReceiptManagementStatusDtos);

            Integer size = wReceiptManagementStatusDtos.size();
            Long total = size.longValue();
            System.out.println("total——————>" + total);

            listResult = Result.success(wReceiptManagementStatusDtos,total);
        } catch (Exception e){
            e.printStackTrace();
        }
        return listResult;
    }


    @ApiOperation(value = "入库信息列表 条件查询")
    @PostMapping(value = "/wReceiptManagement/list")
    public Result<List<WReceiptManagement>> selectList(@RequestBody(required = false) WReceiptManagementQueryDto wReceiptManagementQueryDto){
        Result<List<WReceiptManagement>> listResult = Result.failed("入库信息查询失败！");

        PageInfo<WReceiptManagement> pageInfo = wReceiptManagementService.queryChoiceAll(wReceiptManagementQueryDto);
        List<WReceiptManagement> wReceiptManagements = pageInfo.getList();
        System.out.println("查询记录数————>" + wReceiptManagements);

        Long total = pageInfo.getTotal();
        System.out.println("total————>" + total);

        if(wReceiptManagements != null){
            listResult = Result.success(wReceiptManagements,total);
            return listResult;
        }
        return listResult;
    }


    @ApiOperation("添加 入库单")
    @PostMapping("/wReceiptManagement/add")
    public Result<List<WReceiptDetails>> add(@RequestBody WReceiptManagementAddDto wReceiptManagementAddDto){
        Result<List<WReceiptDetails>> r = Result.failed();

        try{
            List<WReceiptDetails> wReceiptDetails = wReceiptManagementService.add(wReceiptManagementAddDto);

            Integer size = wReceiptDetails.size();
            Long total = size.longValue();
            System.out.println("total————————>" + total);

            r = Result.success(wReceiptDetails,total);
        } catch (Exception e){
            e.printStackTrace();
        }
        return r;
    }

    @ApiOperation("修改 入库单")
    @PostMapping("/wReceiptManagement/update")
    public Result update(@RequestBody WReceiptManagementUpdateDto wReceiptManagementUpdateDto){
        Result r = Result.failed();

        try{
            wReceiptManagementService.update(wReceiptManagementUpdateDto);
            r = Result.success();
        } catch (Exception e){
            e.printStackTrace();
        }
        return r;
    }


}
