package com.gxa.service;

import com.github.pagehelper.PageInfo;
import com.gxa.dto.*;
import com.gxa.entity.Statute;
import com.gxa.entity.WPickingManagement;

public interface WPickingManagementService {
    PageInfo<WPickingManagement> queryByCondition(WPickingManagementQueryDto wPickingManagementQueryDto);
    void add(WPickingManagementAddDto wPickingManagementAddDto);
    void update(WPickingManagementUpdateDto wPickingManagementUpdateDto);
}
