package com.gxa.service;

import com.github.pagehelper.PageInfo;
import com.gxa.dto.*;
import com.gxa.entity.Statute;
import com.gxa.entity.WPickingManagement;

public interface WPickingManagementService {
    Integer addNo();
    PageInfo<WPickingManagement> queryByCondition(WPickingManagementQueryDto wPickingManagementQueryDto);
    void add(WPickingManagementAddDto wPickingManagementAddDto);
    String update(WPickingManagementUpdateDto wPickingManagementUpdateDto);
    String delete(Integer pickingNo);
}
