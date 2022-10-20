package com.gxa.mapper;

import com.gxa.dto.WReceiptManagementDto;
import com.gxa.entity.WReceiptDetails;
import com.gxa.entity.WReceiptManagement;

import java.util.List;

public interface WReceiptManagementMapper {
    //查询所有信息
    List<WReceiptManagement> queryAll();
    //根据条件 查询所有信息
    List<WReceiptManagement> queryChoiceAll(WReceiptManagementDto wReceiptManagementDto);

}
