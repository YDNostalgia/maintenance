package com.gxa.controller;

import com.github.pagehelper.PageInfo;
import com.gxa.dto.WInventoryManagementAddDto;
import com.gxa.dto.WInventoryManagementQueryDto;
import com.gxa.dto.WInventoryManagementUpdateDto;
import com.gxa.entity.WInventoryManagement;
import com.gxa.entity.WPickingDetails;
import com.gxa.service.WInventoryManageMentService;
import com.gxa.utils.R;
import com.gxa.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@Api(tags = "库存盘点接口")
public class WInventoryManagementController {
    @Autowired
    private WInventoryManageMentService wInventoryManageMentService;

    @PostMapping("/wInventoryManagement/list")
    @ApiOperation("查询库存盘点单号")
    public Result<List<WInventoryManagement>> list(@RequestBody WInventoryManagementQueryDto wInventoryManagementQueryDto){
        Result<List<WInventoryManagement>> r=Result.failed();
        PageInfo<WInventoryManagement> pageInfo=wInventoryManageMentService.queryByCondition(wInventoryManagementQueryDto);
        System.out.println("==============="+pageInfo);
        List<WInventoryManagement> wInventoryManagements=pageInfo.getList();
        long total=pageInfo.getTotal();

        if (wInventoryManagements!=null){
            r=Result.success(wInventoryManagements,total);
            return r;
        }
        return r;
    }

    @PostMapping("/WInventoryManagement/add")
    @ApiOperation("添加库存盘点单")
   public Result add(@RequestBody WInventoryManagementAddDto wInventoryManagementAddDto){
        Result r=Result.failed();
        try {
            wInventoryManageMentService.add(wInventoryManagementAddDto);
            r=Result.success();
        }catch (Exception e){
            e.printStackTrace();
        }
        return r;
    }

    @PostMapping("/WInventoryManag/update")
    @ApiOperation("修改库存盘点单")
    public Result update(@RequestBody WInventoryManagementUpdateDto wInventoryManagementUpdateDto){

        Result r=Result.failed();
        try {
            wInventoryManageMentService.update(wInventoryManagementUpdateDto);
            r=Result.success();
        }catch (Exception e){
            e.printStackTrace();
        }
        return r;
    }

}
