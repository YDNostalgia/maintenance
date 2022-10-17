package com.gxa.service;

import com.gxa.dto.DequipDto;
import com.gxa.entity.Dequip;
import com.gxa.entity.Desave;
import com.gxa.entity.Detype;

import java.util.List;

public interface DequipService {

    //根据条件 分页 查询所有信息列表
    List<Dequip> queryChooseList(DequipDto dequipDto);
    //器械分类 下拉列表
    List<Detype> queryType();
    //存放区域 下拉列表
    List<Desave> querySave();

}
