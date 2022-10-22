package com.gxa.mapper;

import com.gxa.dto.WInventoryManagementAddDto;
import com.gxa.dto.WInventoryManagementQueryDto;
import com.gxa.dto.WInventoryManagementUpdateDto;
import com.gxa.entity.WInventoryManagement;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface WInventoryManagementMapper {
    List<WInventoryManagement> queryByCondition(WInventoryManagementQueryDto wInventoryManagementQueryDto);

    Integer queryByInventoryNo(@Param("inventoryNo") Integer inventoryNo);
    void add(WInventoryManagementAddDto wInventoryManagementAddDto);

    void update(WInventoryManagementUpdateDto wInventoryManagementUpdateDto);

    void delete(@Param("inventoryNo") Integer inventoryNo);

}
