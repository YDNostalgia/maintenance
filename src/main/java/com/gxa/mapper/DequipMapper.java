package com.gxa.mapper;

import com.gxa.entity.Dequip;
import com.gxa.entity.DequipToAdd;

import java.util.List;

public interface DequipMapper {
    //查询列表页 分页 条件
    List<Dequip> queryChooseList();

//    void addDequip(DequipDto dequipDto);
//    void updateDequip(Integer id);

    //添加
    void addDequip(DequipToAdd dequipToAdd);
}
