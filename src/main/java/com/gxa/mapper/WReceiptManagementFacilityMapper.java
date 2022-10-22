package com.gxa.mapper;

import com.gxa.dto.WReceiptManagementFacilityDto;

import java.util.List;

public interface WReceiptManagementFacilityMapper {
    //器材名称 下拉查询
    List<WReceiptManagementFacilityDto> queryFacilityName();
    //器材型号 下拉查询
    List<WReceiptManagementFacilityDto> queryFacilityModel(String name);
    //获取 器材编号
    List<WReceiptManagementFacilityDto> queryFacilityNumber(WReceiptManagementFacilityDto wReceiptManagementFacilityDto);
}
