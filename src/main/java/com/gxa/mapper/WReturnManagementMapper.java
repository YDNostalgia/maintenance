package com.gxa.mapper;

import com.gxa.dto.*;
import com.gxa.entity.WPickingManagement;
import com.gxa.entity.WReturnManagement;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface WReturnManagementMapper {
    List<WReturnManagement> queryByCondition(WReturnManagementQueryDto wReturnManagementQueryDto);
    Integer queryByReturnNo(@Param("returnNo") Integer returnNo);
    void add(WReturnManagementAddDto wReturnManagementAddDto);
    void update(WReturnManagementUpdateDto wReturnManagementUpdateDto);
    void delete(@Param("returnNo") Integer returnNo);
}
