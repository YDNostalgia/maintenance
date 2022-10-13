package com.gxa.controller;

import com.gxa.dto.EquipmentManagementDto;
import com.gxa.entity.*;
import com.gxa.service.EquipmentManagementService;
import com.gxa.utils.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
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
    public R listEquipment(EquipmentManagementDto equipmentManagementDto){
        R r=new R();
        //System.out.println(equipmentManagementDto);
        Integer count=this.equipmentManagementService.queryCount(equipmentManagementDto);
        //System.out.println("---------->"+count);
        List<EquipmentManagement> equipmentManagements=this.equipmentManagementService.queryAll(equipmentManagementDto);
       // System.out.println("---------->"+equipmentManagements);
        r.put("count",count);
        r.put("data",equipmentManagements);
        return r;
    }

    @GetMapping("/equipment/preselect")
    @ApiOperation("查询下拉列表信息")
    public R equipmentPreadd( ){
        R r=new R();
        List<EquipmentClass> equipmentClasses=this.equipmentManagementService.queryEquipmentClass();
        List<EquipmentName> equipmentNames=this.equipmentManagementService.queryEquipmentName();
        List<Useunits> useunits=this.equipmentManagementService.queryEquiUseunits();
        List<StorageLocation> storageLocations=this.equipmentManagementService.queryEquipStorageLocation();
        //System.out.println(equipmentNames);
        r.put("equipmentClasses",equipmentClasses);//装备种类名字集合
        r.put("equipmentNames",equipmentNames);//装备名称集合
        r.put("useunits",useunits);//装备名称集合
        r.put("storageLocations",storageLocations);//存放仓库名称
        return r;
    }

    @PostMapping("/equipment/add")
    @ApiOperation("装备添加")
    public R equipmentAdd( ){
        R r=new R();

        return r;
    }

    @PutMapping("/equipment/update")
    @ApiOperation("装备修改")
    public R equipmentUpdate( ){
        R r=new R();

        return r;
    }

    @DeleteMapping("/equipment/delete")
    @ApiOperation("装备删除")
    public R equipmentDelete( ){
        R r=new R();

        return r;
    }
}
