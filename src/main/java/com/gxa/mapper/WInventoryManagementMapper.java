package com.gxa.mapper;

import com.gxa.dto.WInventoryAuditStatusDto;
import com.gxa.dto.WInventoryManagementDto;
import com.gxa.entity.WInventoryDetails;
import com.gxa.entity.WInventoryManagement;

import java.util.List;

public interface WInventoryManagementMapper {
    List<WInventoryManagement> queryAll(WInventoryManagementDto wInventoryManagementDto);

//    Integer count(WInventoryManagementDto wInventoryManagementDto);

    List<WInventoryAuditStatusDto> queryAuditStatus();

    List<WInventoryAuditStatusDto> queryInventoryNo();
    void addWInventoryManagement(WInventoryDetails wInventoryDetails);
}
