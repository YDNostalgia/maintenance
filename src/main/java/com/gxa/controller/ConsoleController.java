package com.gxa.controller;

import com.gxa.dto.EquipmentManagementDto;
import com.gxa.entity.Console;
import com.gxa.entity.RepairCompleted;
import com.gxa.entity.RepairSituation;
import com.gxa.service.ConsoleService;
import com.gxa.utils.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Api(tags = "控制台接口")
public class ConsoleController {
    @Autowired
    private ConsoleService consoleService;
    @GetMapping("/console/list")
    @ApiOperation("装备查询_带条件的查询（不传条件就是查询全部）")
    public R listConsole(@RequestBody(required = false) EquipmentManagementDto equipmentManagementDto, Integer page, Integer limit){
        R r=new R();
        try {
            Integer maintenanceTotal=this.consoleService.queryMaintenanceTotal();
            Integer maintenanceFinishTotal=this.consoleService.queryMaintenanceFinishTotal();
            Integer maintenanceNotFinishTotal=this.consoleService.queryMaintenanceNotFinishTotal();
            Integer maintenancePersonnelTotal=this.consoleService.queryMaintenancePersonnelTotal();
            List<RepairSituation> repairSituations=this.consoleService.queryRepairSituation();
            List<RepairCompleted> repairCompleteds=this.consoleService.queryRepairCompleted();
            Console console= new Console(maintenanceTotal,maintenanceFinishTotal,maintenanceNotFinishTotal
            ,maintenancePersonnelTotal,repairSituations,repairCompleteds);
            r.put("console",console);
        }catch (Exception e){
            r.put("code", 1);
            r.put("msg", "error");
            e.printStackTrace();
        }
        return r;
    }

}
