package com.gxa.controller;

import com.github.pagehelper.PageInfo;
import com.gxa.entity.EquipmentCall;
import com.gxa.entity.MaintenanceProgram;
import com.gxa.entity.RepairProcess;
import com.gxa.entity.PersonnelDrawGroup;
import com.gxa.service.ProfileDetailsService;
import com.gxa.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Api(tags = "档案详情接口")
public class ProfileDetailsController {
    @Autowired
    private ProfileDetailsService profileDetailsService;
    @GetMapping("/profileDetails/repairProcesslist")
    @ApiOperation("查询某个维修档案——维修过程")
    public Result<List<RepairProcess>> listRepairProcesslist(){
        Result<List<RepairProcess>> r=Result.success();
        try {
            List<RepairProcess> repairProcesses=this.profileDetailsService.repairProcesslist();
            PageInfo<RepairProcess> pageInfo = new PageInfo<>(repairProcesses);
            long total = (int) pageInfo.getTotal();
            r=Result.success(repairProcesses,total);
        }catch (Exception e){
            r.setCode("1");
            r.setMsg("error");
            e.printStackTrace();
        }
        return r;
    }

        @GetMapping("/profileDetails/personnelDrawGroups")
    @ApiOperation("查询某个维修档案——人员抽组")
    public Result<List<PersonnelDrawGroup>> personnelDrawGroups(){
        Result<List<PersonnelDrawGroup>> r=Result.success();
        try {
            List<PersonnelDrawGroup> personnelDrawGroups=this.profileDetailsService.personnelDrawGroups();
            PageInfo<PersonnelDrawGroup> pageInfo = new PageInfo<>(personnelDrawGroups);
            long total = (int) pageInfo.getTotal();
            r=Result.success(personnelDrawGroups,total);
        }catch (Exception e){
            r.setCode("1");
            r.setMsg("error");
            e.printStackTrace();
        }
        return r;
    }

    @GetMapping("/profileDetails/equipmentCall")
    @ApiOperation("查询某个维修档案——器材调用")
    public Result<List<EquipmentCall>> equipmentCall(){
        Result<List<EquipmentCall>> r=Result.success();
        try {
            List<EquipmentCall> equipmentCalls=this.profileDetailsService.equipmentCalls();
            PageInfo<EquipmentCall> pageInfo = new PageInfo<>(equipmentCalls);
            long total = (int) pageInfo.getTotal();
            r=Result.success(equipmentCalls,total);
        }catch (Exception e){
            r.setCode("1");
            r.setMsg("error");
            e.printStackTrace();
        }
        return r;
    }
    @GetMapping("/profileDetails/maintenanceProgram")
    @ApiOperation("查询某个维修档案——维修方案")
    public Result<List<MaintenanceProgram>> maintenanceProgram(){
        Result<List<MaintenanceProgram>> r=Result.success();
        try {
            List<MaintenanceProgram> maintenancePrograms=this.profileDetailsService.maintenanceProgram();
            PageInfo<MaintenanceProgram> pageInfo = new PageInfo<>(maintenancePrograms);
            long total = (int) pageInfo.getTotal();
            r=Result.success(maintenancePrograms,total);
        }catch (Exception e){
            r.setCode("1");
            r.setMsg("error");
            e.printStackTrace();
        }
        return r;
    }
}
