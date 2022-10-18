package com.gxa.service.impl;

import com.gxa.entity.EquipmentCall;
import com.gxa.entity.MaintenanceProgram;
import com.gxa.entity.PersonnelDrawGroup;
import com.gxa.entity.RepairProcess;
import com.gxa.mapper.EquipmentManagementMapper;
import com.gxa.mapper.RepairProcesslistMapper;
import com.gxa.service.ProfileDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfileDetailsServiceImpl implements ProfileDetailsService {

    @Autowired
    private RepairProcesslistMapper repairProcesslistMapper;
    @Override
    public List<RepairProcess> repairProcesslist() {
        List<RepairProcess> repairProcesses=this.repairProcesslistMapper.repairProcesslist();
        return repairProcesses;
    }

    @Override
    public List<PersonnelDrawGroup> personnelDrawGroups() {
        List<PersonnelDrawGroup> personnelDrawGroups=this.repairProcesslistMapper.personnelDrawGroup();
        return personnelDrawGroups;
    }

    @Override
    public List<EquipmentCall> equipmentCalls() {
        List<EquipmentCall> equipmentCalls=this.repairProcesslistMapper.equipmentCall();
        return equipmentCalls;
    }

    @Override
    public List<MaintenanceProgram> maintenanceProgram() {
        List<MaintenanceProgram> maintenancePrograms=this.repairProcesslistMapper.maintenancePrograms();
        return maintenancePrograms;
    }
}
