package com.gxa.controller;

import com.gxa.dto.EquipmentManagementDto;
import com.gxa.entity.EquipmentManagement;
import com.gxa.service.EquipmentManagementService;
import com.gxa.utils.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import java.util.List;

@Controller
@Api(value = "装备接口")
public class EquipmentManagementController {

    @Autowired
    private EquipmentManagementService equipmentManagementService;

    @ResponseBody
    @RequestMapping("/equipment")
    @ApiOperation("装备查询")
    public R listEquipment(EquipmentManagementDto equipmentManagementDto){
        System.out.println(equipmentManagementDto);
             Integer count=this.equipmentManagementService.queryCount(equipmentManagementDto);
             List<EquipmentManagement> equipmentManagements=this.equipmentManagementService.queryAll(equipmentManagementDto);
             R r=new R();
             //1
             r.put("count",count);
             r.put("data",equipmentManagements);
             return r;
    }
}
