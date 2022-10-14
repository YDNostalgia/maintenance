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
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@Api(value = "装备接口")
public class EquipmentManagementController {

    @Autowired
    private EquipmentManagementService equipmentManagementService;
    @ResponseBody
    @GetMapping("/equipment/list")
    @ApiOperation("装备查询")
    public Result<List<EquipmentManagement>> listEquipment(EquipmentManagementDto equipmentManagementDto, Integer page, Integer limit){
        Result<List<EquipmentManagement>> r=Result.success();
        try {
            PageHelper.startPage(page,limit);
            List<EquipmentManagement> equipmentManagements=this.equipmentManagementService.queryAll(equipmentManagementDto);
            PageInfo<EquipmentManagement> pageInfo = new PageInfo<>(equipmentManagements);
            long total = (int) pageInfo.getTotal();
             r=Result.success(equipmentManagements,total);
        }catch (Exception e){
            r.setCode("1");
            r.setMsg("error");
            e.printStackTrace();
        }
        return r;
    }

    @GetMapping("/equipment/preselect")
    @ApiOperation("查询下拉列表信息 1.装备名称(equipmentNames) 2.装备种类名称(equipmentClasses) 3.存放仓库名称(storageLocationName)" +
            "4.使用单位名称(useunits) ")
    public R equipmentPreadd(){
        R r=new R();
            List<EquipmentClass> equipmentClasses=this.equipmentManagementService.queryEquipmentClass();
            List<EquipmentName> equipmentNames=this.equipmentManagementService.queryEquipmentName();
            List<Useunits> useunits=this.equipmentManagementService.queryEquiUseunits();
            List<StorageLocation> storageLocations=this.equipmentManagementService.queryEquipStorageLocation();
            //System.out.println(equipmentNames);
            System.out.println(equipmentClasses);
            r.put("equipmentClasses",equipmentClasses);//装备种类名字集合
            r.put("equipmentNames",equipmentNames);//装备名称集合
            r.put("useunits",useunits);//装备名称集合
            r.put("storageLocations",storageLocations);//存放仓库名称
        return r;
    }

    @PostMapping("/equipment/add")
    @ApiOperation("装备添加")
    public Result<EquipmentManagementAU> equipmentAdd(EquipmentManagementAU equipmentManagementAU){
        //R r=new R();
        Result<EquipmentManagementAU> r=Result.success();
        try {
            this.equipmentManagementService.addEquipmentManagement(equipmentManagementAU);
             r=Result.success();
        }catch (Exception e){
            r.setCode("1");
            r.setMsg("error");
            e.printStackTrace();
        }
        return r;
    }

    @PutMapping("/equipment/update")
    @ApiOperation("装备修改")
    public Result<EquipmentManagementAU> equipmentUpdate(EquipmentManagementAU equipmentManagementAU){
        //System.out.println(equipmentManagementAU);
        Result<EquipmentManagementAU> r=Result.success();
        try {
            this.equipmentManagementService.updateEquipmentManagement(equipmentManagementAU);
             r=Result.success();
        }catch (Exception e){
            r.setCode("1");
            r.setMsg("error");
            e.printStackTrace();
        }
        return r;
    }

    @DeleteMapping("/equipment/delete")
    @ApiOperation("装备删除")
    public R equipmentDelete(@RequestParam("id") Integer id){
        R r=new R();
        try{
            this.equipmentManagementService.deleteEquipmentManagement(id);
        }catch (Exception e){
            r.put("code",1);
            r.put("msg","error");
            e.printStackTrace();
        }
        return r;
    }
}
