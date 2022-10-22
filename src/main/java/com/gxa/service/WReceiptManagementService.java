package com.gxa.service;

import com.github.pagehelper.PageInfo;
import com.gxa.dto.*;
import com.gxa.entity.WReceiptDetails;
import com.gxa.entity.WReceiptManagement;

import java.util.List;

public interface WReceiptManagementService {
    //查询所有信息
    List<WReceiptManagement> queryAll();
    //审核状态 下拉列表
    List<WReceiptManagementStatusDto> queryByStatus();
    //根据条件 查询所有信息
    PageInfo<WReceiptManagement> queryChoiceAll(WReceiptManagementQueryDto wReceiptManagementQueryDto);

    //生成 入库单号
    Integer addNo();

    List<WReceiptDetails> add(WReceiptManagementAddDto wReceiptManagementAddDto);

    String update(WReceiptManagementUpdateDto wReceiptManagementUpdateDto);

    String delete(Integer receiptNo);

}
