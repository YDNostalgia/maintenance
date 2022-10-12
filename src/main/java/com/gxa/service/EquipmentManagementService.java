package com.gxa.service;

import com.gxa.dto.EquipmentManagementDto;
import com.gxa.entity.EquipmentManagement;

import java.util.List;

public interface EquipmentManagementService {
    List<EquipmentManagement> queryAll(EquipmentManagementDto equipmentManagementDto);
}
