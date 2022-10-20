package com.gxa.service;

import com.gxa.dto.WInventoryAuditStatusDto;
import com.gxa.dto.WInventoryManagementDto;
import com.gxa.entity.WInventoryDetails;
import com.gxa.entity.WInventoryManagement;

import java.util.List;

public interface WInventoryManageMentService {
    List<WInventoryManagement> queryAll(WInventoryManagementDto wInventoryManagementDto);
//    Integer count(WInventoryManagementDto wInventoryManagementDto);

    List<WInventoryAuditStatusDto> queryAuditStatus();

    List<WInventoryAuditStatusDto> queryInventoryNo();

    void addWInventoryManagement(WInventoryDetails wInventoryDetails);
}
