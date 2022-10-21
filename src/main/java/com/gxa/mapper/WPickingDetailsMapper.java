package com.gxa.mapper;

import com.gxa.dto.WPickingDetailsAddDto;
import com.gxa.dto.WPickingManagementAddDto;
import com.gxa.dto.WPickingManagementQueryDto;
import com.gxa.entity.WPickingDetails;
import com.gxa.entity.WPickingManagement;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface WPickingDetailsMapper {
    List<WPickingDetails> queryByPickingNo(@Param("pickingNo") Integer pickingNo);
    void add(List<WPickingDetailsAddDto> wPickingDetailsAddDtos);
    void delete(Integer pickingNo);
}
