package com.gxa.mapper;

import com.gxa.dto.WReceiptManagementStatusDto;

import java.util.List;

public interface WReceiptManagementStatusMapper {
    //审核状态 下拉列表
    List<WReceiptManagementStatusDto> queryByStatus();
}
