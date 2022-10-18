package com.gxa.mapper;


import com.gxa.entity.EquipmentCall;
import com.gxa.entity.MaintenanceProgram;
import com.gxa.entity.PersonnelDrawGroup;
import com.gxa.entity.RepairProcess;

import java.util.List;

public interface RepairProcesslistMapper {
    List<RepairProcess> repairProcesslist();
    List<PersonnelDrawGroup> personnelDrawGroup();
    List<EquipmentCall> equipmentCall();
    List<MaintenanceProgram> maintenancePrograms();
}
