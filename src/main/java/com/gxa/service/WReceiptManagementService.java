package com.gxa.service;

import com.gxa.dto.WReceiptManagementDto;
import com.gxa.dto.WReceiptManagementFacilityDto;
import com.gxa.dto.WReceiptManagementStatusDto;
import com.gxa.entity.WReceiptManagement;

import java.util.List;

public interface WReceiptManagementService {
    //查询所有信息
    List<WReceiptManagement> queryAll();
    //审核状态 下拉列表
    List<WReceiptManagementStatusDto> queryByStatus();
    //根据条件 查询所有信息
    List<WReceiptManagement> queryChoiceAll(WReceiptManagementDto wReceiptManagementDto);

    //器材名称 下拉列表
    List<WReceiptManagementFacilityDto> queryFacilityName();
    //器材型号 下拉列表
    List<WReceiptManagementFacilityDto> queryFacilityModel(String name);
    //获取 器材编号
    List<WReceiptManagementFacilityDto> queryFacilityNumber(WReceiptManagementFacilityDto wReceiptManagementFacilityDto);
}
