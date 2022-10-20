package com.gxa.service.impl;

import com.gxa.dto.WInventoryAuditStatusDto;
import com.gxa.dto.WInventoryManagementDto;
import com.gxa.entity.WInventoryDetails;
import com.gxa.entity.WInventoryManagement;
import com.gxa.mapper.WInventoryManagementMapper;
import com.gxa.service.WInventoryManageMentService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class WIventoryManagementServiceImpl implements WInventoryManageMentService {

    private WInventoryManagementMapper wInventoryManagementMapper;

    @Override
    public List<WInventoryManagement> queryAll(WInventoryManagementDto wInventoryManagementDto) {
        List<WInventoryManagement> wInventoryManagements=this.wInventoryManagementMapper.queryAll(wInventoryManagementDto);
        return wInventoryManagements;
    }
//
//    @Override
//    public Integer count(WInventoryManagementDto wInventoryManagementDto) {
//
//        return null;
//    }

    @Override
    public List<WInventoryAuditStatusDto> queryAuditStatus() {
        List<WInventoryAuditStatusDto> auditStatus=this.wInventoryManagementMapper.queryAuditStatus();
        return auditStatus;
    }

    @Override
    public List<WInventoryAuditStatusDto> queryInventoryNo() {
        List<WInventoryAuditStatusDto> inventoryNo=this.wInventoryManagementMapper.queryInventoryNo();
        return inventoryNo;
    }

    @Override
    public void addWInventoryManagement(WInventoryDetails wInventoryDetails) {

    }
}
