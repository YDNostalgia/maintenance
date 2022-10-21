package com.gxa.mapper;

import com.gxa.dto.WAccountDetailsAddDto;
import com.gxa.dto.WAccountDetailsQueryDto;
import com.gxa.dto.WAccountDetailsUpdateDto;
import com.gxa.dto.WPickingDetailsAddDto;
import com.gxa.entity.WAccountDetails;
import com.gxa.entity.WPickingDetails;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface WAccountDetailsMapper {
    WAccountDetails queryByCondition(WAccountDetailsQueryDto wAccountDetailsQueryDto);
    List<Integer> queryByWfacilityManagementId(@Param("wfacilityManagementId") Integer wfacilityManagementId,@Param("code") Integer code);
    void add(List<WAccountDetailsAddDto> wAccountDetailsAddDtos);
    void update(WAccountDetailsUpdateDto wAccountDetailsUpdateDto);
}
