package com.gxa.controller;

import com.gxa.entity.EquipmentManagement;
import com.gxa.service.EquipmentManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import java.util.List;

@Controller
public class EquipmentManagementController {

    @Autowired
    private EquipmentManagementService equipmentManagementService;

    @ResponseBody
    @RequestMapping("/equipment")
    public List<EquipmentManagement> listEquipment(){
             List<EquipmentManagement> equipmentManagements=this.equipmentManagementService.queryAll();
             System.out.println(equipmentManagements);
             return equipmentManagements;
    }
}
