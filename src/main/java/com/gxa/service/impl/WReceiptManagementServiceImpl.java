package com.gxa.service.impl;

import com.gxa.dto.WReceiptManagementDto;
import com.gxa.dto.WReceiptManagementFacilityDto;
import com.gxa.dto.WReceiptManagementStatusDto;
import com.gxa.entity.WReceiptManagement;
import com.gxa.mapper.WReceiptManagementFacilityMapper;
import com.gxa.mapper.WReceiptManagementMapper;
import com.gxa.mapper.WReceiptManagementStatusMapper;
import com.gxa.service.WReceiptManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WReceiptManagementServiceImpl implements WReceiptManagementService {

    @Autowired
    private WReceiptManagementMapper wReceiptManagementMapper;
    @Autowired
    private WReceiptManagementStatusMapper wReceiptManagementStatusMapper;
    @Autowired
    private WReceiptManagementFacilityMapper wReceiptManagementFacilityMapper;

    @Override
    public List<WReceiptManagement> queryAll() {
        List<WReceiptManagement> wReceiptManagements = this.wReceiptManagementMapper.queryAll();
        return wReceiptManagements;
    }

    @Override
    public List<WReceiptManagementStatusDto> queryByStatus() {
        List<WReceiptManagementStatusDto> wReceiptManagementStatusDtos = this.wReceiptManagementStatusMapper.queryByStatus();
        return wReceiptManagementStatusDtos;
    }

    @Override
    public List<WReceiptManagement> queryChoiceAll(WReceiptManagementDto wReceiptManagementDto) {
        List<WReceiptManagement> wReceiptManagements = this.wReceiptManagementMapper.queryChoiceAll(wReceiptManagementDto);
        return wReceiptManagements;
    }

    @Override
    public List<WReceiptManagementFacilityDto> queryFacilityName() {
        List<WReceiptManagementFacilityDto> wReceiptManagementFacilityDtos = this.wReceiptManagementFacilityMapper.queryFacilityName();
        return wReceiptManagementFacilityDtos;
    }

    @Override
    public List<WReceiptManagementFacilityDto> queryFacilityModel(String name) {
        List<WReceiptManagementFacilityDto> wReceiptManagementFacilityDtos = this.wReceiptManagementFacilityMapper.queryFacilityModel(name);
        return wReceiptManagementFacilityDtos;
    }

    @Override
    public List<WReceiptManagementFacilityDto> queryFacilityNumber(WReceiptManagementFacilityDto wReceiptManagementFacilityDto) {
        List<WReceiptManagementFacilityDto> wReceiptManagementFacilityDtos = this.wReceiptManagementFacilityMapper.queryFacilityNumber(wReceiptManagementFacilityDto);
        return wReceiptManagementFacilityDtos;
    }
}
