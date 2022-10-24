package com.gxa.mapper;

import com.gxa.dto.WPickingManagementAddDto;
import com.gxa.dto.WPickingManagementQueryDto;
import com.gxa.dto.WPickingManagementUpdateDto;
import com.gxa.entity.WPickingManagement;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface DocNoGenerationUtilMapper {
    void addNo(Map<String,Integer> limitValue);
    Integer queryQuantity(Map<String,Integer> limitValue);
}
