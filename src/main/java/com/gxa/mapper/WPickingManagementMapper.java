package com.gxa.mapper;

import com.gxa.dto.WPickingManagementAddDto;
import com.gxa.dto.WPickingManagementQueryDto;
import com.gxa.dto.WPickingManagementUpdateDto;
import com.gxa.entity.WPickingManagement;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface WPickingManagementMapper {
    List<WPickingManagement> queryByCondition(WPickingManagementQueryDto wPickingManagementQueryDto);
    Integer queryByPickingNo(@Param("pickingNo") Integer pickingNo);
    void add(WPickingManagementAddDto wPickingManagementAddDto);
    void update(WPickingManagementUpdateDto wPickingManagementUpdateDto);
    void delete(@Param("pickingNo") Integer pickingNo);
}
