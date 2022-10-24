package com.gxa.mapper;

import com.gxa.dto.EquipCallDto;
import com.gxa.entity.EquipCall;
import com.gxa.entity.KeepManagement;

import java.util.List;

public interface EquipmentCallMapper {
    List<EquipCall> queryEquipmentCallById(int id);

    void addEquipmentCall(EquipCallDto equipCallDto);
    List<KeepManagement> queryAllEquipment();
}
