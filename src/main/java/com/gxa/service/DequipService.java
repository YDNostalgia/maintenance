package com.gxa.service;

import com.gxa.dto.DequipDto;
import com.gxa.entity.Dequip;

import java.util.List;

public interface DequipService {
    //查询所有信息列表
    List<Dequip> queryList();
    //根据条件 分页 查询所有信息列表
    List<Dequip> queryChooseList(DequipDto dequipDto);
}
