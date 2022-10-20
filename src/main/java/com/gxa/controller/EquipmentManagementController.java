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


import java.util.ArrayList;
import java.util.List;

@RestController
@Api(tags = "装备管理接口")
public class EquipmentManagementController {

    @Autowired
    private EquipmentManagementService equipmentManagementService;
    @PostMapping("/equipment/list")
    @ApiOperation("装备查询_带条件的查询（不传条件就是查询全部）")
    public Result<List<EquipmentManagement>> listEquipment(@RequestBody(required = false)  EquipmentManagementDto equipmentManagementDto, Integer page, Integer limit){
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
    @GetMapping("/equipment/list/equipmentlist")
    @ApiOperation("查询某个装备——器材清单")
    public Result<List<EquipmentList>> listEquipmentOne( Integer page, Integer limit){
        Result<List<EquipmentList>> r=Result.success();
        try {
            PageHelper.startPage(page,limit);
            List<EquipmentList> equipmentLists=this.equipmentManagementService.querylistEquipmentone();
            PageInfo<EquipmentList> pageInfo = new PageInfo<>(equipmentLists);
            long total = (int) pageInfo.getTotal();
            r=Result.success(equipmentLists,total);
        }catch (Exception e){
            r.setCode("1");
            r.setMsg("error");
            e.printStackTrace();
        }
        return r;
    }
    @GetMapping("/equipment/list/maintenancerecords")
    @ApiOperation("查询某个装备——维修记录")
    public Result<List<MaintenanceRecords>> listEquipmentTwo( Integer page, Integer limit){
        Result<List<MaintenanceRecords>> r=Result.success();
        try {
            PageHelper.startPage(page,limit);
            List<MaintenanceRecords> maintenanceRecords=this.equipmentManagementService.querylistMaintenanceRecords();
            PageInfo<MaintenanceRecords> pageInfo = new PageInfo<>(maintenanceRecords);
            long total = (int) pageInfo.getTotal();
            r=Result.success(maintenanceRecords,total);
        }catch (Exception e){
            r.setCode("1");
            r.setMsg("error");
            e.printStackTrace();
        }
        return r;
    }
    @GetMapping("/equipment/list/technicalData")
    @ApiOperation("查询某个装备——技术资料")
    public Result<List<TechnicalData>> listEquipmentThree( Integer page, Integer limit){
        Result<List<TechnicalData>> r=Result.success();
        try {
            PageHelper.startPage(page,limit);
            List<TechnicalData> technicalData=this.equipmentManagementService.querylistTechnicalData();
            PageInfo<TechnicalData> pageInfo = new PageInfo<>(technicalData);
            long total = (int) pageInfo.getTotal();
            r=Result.success(technicalData,total);
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
            r.put("useunits",useunits);//使用单位集合
            r.put("storageLocations",storageLocations);//存放仓库名称
        return r;
    }

    @PostMapping("/equipment/add")
    @ApiOperation("装备添加")
    public Result<EquipmentManagementAU> equipmentAdd(@RequestBody EquipmentManagementAU equipmentManagementAU){
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
    public Result<EquipmentManagementAU> equipmentUpdate(@RequestBody EquipmentManagementAU equipmentManagementAU){
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
    public R equipmentDelete(Integer id){
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
    @DeleteMapping("/equipment/deleteidss")
    @ApiOperation("装备多选删除")
    public R equipmentDeleteIdss(@RequestBody List<Integer> ids){
        System.out.println(ids);
        R r=new R();
        try{
            this.equipmentManagementService.deleteEquipmentManagementByIds(ids);
        }catch (Exception e){
            r.put("code",1);
            r.put("msg","error");
            e.printStackTrace();
        }
        return r;
    }

//    @DeleteMapping("/equipment/deleteids")
//    @ApiOperation("装备多选删除1 _String")
//    public R equipmentDeleteIds(@RequestBody String ids) {
//        R r = new R();
//        try {
//            if (ids.contains(",")) {
//                String[] splitId = ids.split(",");
//                System.out.println(splitId);
//                List<Integer> list = new ArrayList<Integer>();
//                //遍历split字符串数组
//                for (String id : splitId) {
//                    int i = 0;
//                    try {
//                        //将String字符类型数据转换为Integer整型数据
//                        i = Integer.parseInt(id);
//                    } catch (NumberFormatException e) {
//                        e.printStackTrace();
//                    }
//                    //将转换的整形数据添加到集合里
//                    list.add(i);
//                }
//                //遍历list集合,删除id所在的集合
//                for (Integer id : list) {
//                    this.equipmentManagementService.deleteEquipmentManagement(id);
//                }
//            }else {
//                //删除只有一个id
//                this.equipmentManagementService.deleteEquipmentManagement(Integer.parseInt(ids));
//            }
//        }catch (Exception e){
//            r.put("code",1);
//            r.put("msg","error");
//            e.printStackTrace();
//        }
//        return r;
//    }
}
