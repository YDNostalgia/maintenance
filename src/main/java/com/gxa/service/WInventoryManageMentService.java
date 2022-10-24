package com.gxa.service;

import com.github.pagehelper.PageInfo;
import com.gxa.dto.*;
import com.gxa.entity.WInventoryDetails;
import com.gxa.entity.WInventoryManagement;

import java.util.List;

public interface WInventoryManageMentService {
  Integer addNo();
  PageInfo<WInventoryManagement> queryByCondition(WInventoryManagementQueryDto wInventoryManagementQueryDto);

  void add(WInventoryManagementAddDto wInventoryManagementAddDto);

  String update(WInventoryManagementUpdateDto wInventoryManagementUpdateDto);
  String delete(Integer inventoryNo);

}
