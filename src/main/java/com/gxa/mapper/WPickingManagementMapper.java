package com.gxa.mapper;

import com.gxa.dto.WPickingManagementAddDto;
import com.gxa.dto.WPickingManagementQueryDto;
import com.gxa.dto.WPickingManagementUpdateDto;
import com.gxa.entity.WPickingManagement;

import java.util.List;

public interface WPickingManagementMapper {
    List<WPickingManagement> queryByCondition(WPickingManagementQueryDto wPickingManagementQueryDto);
    void add(WPickingManagementAddDto wPickingManagementAddDto);
    void update(WPickingManagementUpdateDto wPickingManagementUpdateDto);
}
