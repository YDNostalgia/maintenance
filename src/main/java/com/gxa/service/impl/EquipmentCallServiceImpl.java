package com.gxa.service.impl;

import com.gxa.dto.EquipCallDto;
import com.gxa.entity.EquipCall;
import com.gxa.entity.KeepManagement;
import com.gxa.mapper.EquipmentCallMapper;
import com.gxa.service.EquipmentCallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EquipmentCallServiceImpl implements EquipmentCallService {

    @Autowired
    private EquipmentCallMapper equipmentCallMapper ;


    @Override
    public List<EquipCall> queryEquipmentCallById(int id) {
        List<EquipCall> equipCalls = equipmentCallMapper.queryEquipmentCallById(id);
        return equipCalls;
    }

    @Override
    public void addEquipmentCall(EquipCallDto equipCallDto) {

        equipmentCallMapper.addEquipmentCall(equipCallDto);
    }

    @Override
    public List<KeepManagement> queryAllEquipment() {
        List<KeepManagement> keepManagements = equipmentCallMapper.queryAllEquipment();
        return keepManagements;
    }
}
