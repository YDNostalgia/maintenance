package com.gxa.service;

import com.gxa.entity.EquipmentCall;
import com.gxa.entity.MaintenanceProgram;
import com.gxa.entity.PersonnelDrawGroup;
import com.gxa.entity.RepairProcess;

import java.util.List;

public interface ProfileDetailsService {
    List<RepairProcess> repairProcesslist();
    List<PersonnelDrawGroup> personnelDrawGroups();
    List<EquipmentCall> equipmentCalls();
    List<MaintenanceProgram> maintenanceProgram();
}
