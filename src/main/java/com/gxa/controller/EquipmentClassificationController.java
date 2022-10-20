package com.gxa.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.gxa.dto.EquipmentManagementDto;
import com.gxa.entity.*;
import com.gxa.service.EquipmentManagementService;
import com.gxa.utils.R;
import com.gxa.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(tags = "装备分类接口")
public class EquipmentClassificationController {
    @Autowired
    private EquipmentManagementService equipmentManagementService;
    @GetMapping("/equipmentclassification/list")
    @ApiOperation("装备分类查询")
    public Result<List<EquipmentClassification>> equipmentclassificationList(Integer limit,Integer page){

        Result<List<EquipmentClassification>> r=Result.success();
        try {
            PageHelper.startPage(page,limit);
            List<EquipmentClassification> equipmentClassifications=this.equipmentManagementService.queryAllEquipmentClassifications();
            PageInfo<EquipmentClassification> pageInfo = new PageInfo<>(equipmentClassifications);
            long total = (int) pageInfo.getTotal();
            r=Result.success(equipmentClassifications,total);
        }catch (Exception e){
            r.setCode("1");
            r.setMsg("error");
            e.printStackTrace();
        }
        return r;
    }

    @PostMapping("/equipmentclassification/add")
    @ApiOperation("添加装备分类")
    public Result<EquipmentClass> equipmentClassificationAdd(@RequestBody EquipmentClass equipmentClassName){
        //R r=new R();
        Result<EquipmentClass> r=Result.success();
        try {
            this.equipmentManagementService.addEquipmentClassification(equipmentClassName);
            r=Result.success();
        }catch (Exception e){
            r.setCode("1");
            r.setMsg("error");
            e.printStackTrace();
        }
        return r;
    }
    @PutMapping("/equipmentclassification/update")
    @ApiOperation("装备分类名称修改")
    public Result<EquipmentClass> equipmentClassificationUpdate(@RequestBody EquipmentClass equipmentClass){
        //R r=new R();
        Result<EquipmentClass> r=Result.success();
        try {
            this.equipmentManagementService.updateEquipmentClassification(equipmentClass);
            r=Result.success();
        }catch (Exception e){
            r.setCode("1");
            r.setMsg("error");
            e.printStackTrace();
        }
        return r;
    }
    @DeleteMapping("/equipmentclassification/delete")
    @ApiOperation("装备分类删除")
    public R equipmentClassificationDelete( Integer id){
        System.out.println(id);
        R r=new R();
        try{
            this.equipmentManagementService.deleteEquipmentClassification(id);
        }catch (Exception e){
            r.put("code",1);
            r.put("msg","error");
            e.printStackTrace();
        }
        return r;
    }

    @GetMapping("/equipmentclassification/list/droplist")
    @ApiOperation("装备分类_具体种类的下拉查询")
    public Result<List<EquipmentName>> equipmentclassificationDropList(@RequestBody String equipmentClassificationName){
        Result<List<EquipmentName>> r=Result.success();
        try {
            List<EquipmentName> equipmentNames=this.equipmentManagementService.equipmentclassificationDropList(equipmentClassificationName);
            r=Result.success(equipmentNames);
        }catch (Exception e){
            r.setCode("1");
            r.setMsg("error");
            e.printStackTrace();
        }
        return r;
    }

    @PutMapping("/equipmentclassification/droplist/update")
    @ApiOperation("装备分类_下拉名称修改")
    public Result<EquipmentName> equipmentclassificationUpdate(@RequestBody EquipmentName equipmentName){
        //System.out.println(equipmentManagementAU);
        Result<EquipmentName> r=Result.success();
        try {
            this.equipmentManagementService.updateEquipmentclassification(equipmentName);
            r=Result.success();
        }catch (Exception e){
            r.setCode("1");
            r.setMsg("error");
            e.printStackTrace();
        }
        return r;
    }

}
