package com.gxa.mapper;

import com.gxa.dto.WReceiptManagementAddDto;
import com.gxa.dto.WReceiptManagementQueryDto;
import com.gxa.dto.WReceiptManagementUpdateDto;
import com.gxa.entity.WReceiptDetails;
import com.gxa.entity.WReceiptManagement;

import java.util.List;

public interface WReceiptManagementMapper {
    //查询所有信息
    List<WReceiptManagement> queryAll();
    //根据条件 查询所有信息
    List<WReceiptManagement> queryChoiceAll(WReceiptManagementQueryDto WReceiptManagementQueryDto);

    //添加 入库单
    void add(WReceiptManagementAddDto wReceiptManagementAddDto);

    void update(WReceiptManagementUpdateDto wReceiptManagementUpdateDto);
}
