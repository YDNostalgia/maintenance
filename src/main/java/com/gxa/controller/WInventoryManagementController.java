package com.gxa.controller;

import com.github.pagehelper.PageInfo;
import com.gxa.dto.WInventoryManagementAddDto;
import com.gxa.dto.WInventoryManagementQueryDto;
import com.gxa.dto.WInventoryManagementUpdateDto;
import com.gxa.entity.WInventoryManagement;
import com.gxa.service.WInventoryManageMentService;
import com.gxa.utils.R;
import com.gxa.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@Api(tags = "库存盘点接口")
public class WInventoryManagementController {
    @Autowired
    private WInventoryManageMentService wInventoryManageMentService;

    @ApiOperation("生成盘点单号")
    @GetMapping("/WInventoryManagement/addNo")
    public Result addNo(){

        Result r = Result.failed();
        try {
            Integer inventoryNo = wInventoryManageMentService.addNo();
            r = Result.success(inventoryNo);
        }catch (Exception e){
            e.printStackTrace();
        }
        return r;
    }

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
    @ApiOperation("审核库存盘点单")
    public Result update(@RequestBody WInventoryManagementUpdateDto wInventoryManagementUpdateDto){

        Result r=Result.failed();
        try {
            String msg=wInventoryManageMentService.update(wInventoryManagementUpdateDto);
            if (msg.equals("审核成功")){
                r=Result.success();
                r.setMsg(msg);
            }else {
                r=Result.failed(msg);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return r;
    }

    @ApiOperation("删除库存盘点单")
    @DeleteMapping("/WInventoryManagement/delete")
    public Result  delete(@Param("inventoryNo") Integer inventoryNo){

        Result r = Result.failed();
        try {
            String msg = wInventoryManageMentService.delete(inventoryNo);
            if ( msg.equals("删除成功")){
                r = Result.success();
                r.setMsg(msg);
            }else {
                r = Result.failed(msg);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return r;
    }


}
