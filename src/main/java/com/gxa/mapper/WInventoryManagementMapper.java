package com.gxa.mapper;

import com.gxa.dto.WInventoryManagementAddDto;
import com.gxa.dto.WInventoryManagementQueryDto;
import com.gxa.dto.WInventoryManagementUpdateDto;
import com.gxa.entity.WInventoryManagement;

import java.util.List;

public interface WInventoryManagementMapper {
    List<WInventoryManagement> queryByCondition(WInventoryManagementQueryDto wInventoryManagementQueryDto);

    void add(WInventoryManagementAddDto wInventoryManagementAddDto);

    void update(WInventoryManagementUpdateDto wInventoryManagementUpdateDto);

}
