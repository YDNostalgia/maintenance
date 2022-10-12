package com.gxa.mapper;

import com.gxa.dto.EquipmentManagementDto;
import com.gxa.entity.EquipmentManagement;

import java.util.List;

public interface EquipmentManagementMapper {
    List<EquipmentManagement> queryAllEquipmentManagement(EquipmentManagementDto equipmentManagementDto);
}
