package com.gxa.controller;

import com.github.pagehelper.PageInfo;
import com.gxa.dto.EquipCallDto;
import com.gxa.dto.KeepPlanDto;
import com.gxa.entity.EquipCall;
import com.gxa.entity.KeepManagement;
import com.gxa.entity.KeepPlan;
import com.gxa.entity.KeepPlanAU;
import com.gxa.service.EquipmentCallService;
import com.gxa.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Api(tags = "器材调用 接口")
public class EquipmentCallController {

    @Autowired
    private EquipmentCallService equipmentCallService;
    private Result<Integer> r;

    @ApiOperation("器材调用 查询")
    @PostMapping("/EquipmentCall/queryAllEquipmentCall")
    public Result<List<EquipCall>> queryAllKeepPlan(int id){
        System.out.println("id---------->" +id);
        Result<List<EquipCall>> r = Result.success();
        try{
            List<EquipCall> equipCalls = equipmentCallService.queryEquipmentCallById(id);
            r = Result.success(equipCalls);
        }catch (Exception e){
            e.printStackTrace();
            Result.failed();
        }
        return r;
    }


    @ApiOperation("维修计划添加")
    @PostMapping("/EquipmentCall/add")
    public Result<Integer> addEquipmentCall(@RequestBody(required = false) EquipCallDto equipCallDto){
        Result<Integer> r = Result.success();
        try {
            System.out.println("EquipCallDto-----"+equipCallDto);
            equipmentCallService.addEquipmentCall(equipCallDto);
        }catch (Exception e){
            e.printStackTrace();
            Result.failed();
        }
        return r;
    }

    @ApiOperation("器材下拉 查询")
    @PostMapping("/EquipmentCall/queryAllEquipment")
    public Result<List<KeepManagement>> queryAllEquipment(){
        Result<List<KeepManagement>> r = Result.success();
        try{
            List<KeepManagement> keepManagements = equipmentCallService.queryAllEquipment();
            r = Result.success(keepManagements);
        }catch (Exception e){
            e.printStackTrace();
            Result.failed();
        }
        return r;
    }
}
