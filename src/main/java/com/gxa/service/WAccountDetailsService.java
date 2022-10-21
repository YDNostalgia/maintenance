package com.gxa.service;

import com.github.pagehelper.PageInfo;
import com.gxa.dto.WAccountDetailsQueryDto;
import com.gxa.dto.WPickingManagementAddDto;
import com.gxa.dto.WPickingManagementQueryDto;
import com.gxa.dto.WPickingManagementUpdateDto;
import com.gxa.entity.WAccountDetails;
import com.gxa.entity.WPickingManagement;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface WAccountDetailsService {
    List<Integer> queryByWfacilityManagementId(Integer wfacilityManagementId,Integer code);
    WAccountDetails queryByCondition(WAccountDetailsQueryDto wAccountDetailsQueryDto);
}
