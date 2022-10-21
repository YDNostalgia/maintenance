package com.gxa.service;

import com.github.pagehelper.PageInfo;
import com.gxa.dto.*;
import com.gxa.entity.WPickingManagement;
import com.gxa.entity.WReturnManagement;

public interface WReturnManagementService {
    Integer addNo();
    PageInfo<WReturnManagement> queryByCondition(WReturnManagementQueryDto wReturnManagementQueryDto);
    void add(WReturnManagementAddDto wReturnManagementAddDto);
    String update(WReturnManagementUpdateDto wReturnManagementUpdateDto);
    String delete(Integer pickingNo);
}
