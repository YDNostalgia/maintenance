package com.gxa.mapper;

import com.gxa.dto.DequipDto;
import com.gxa.entity.Dequip;

import java.util.List;

public interface DequipMapper {
    //查询列表页 分页 条件
    List<Dequip> queryChooseList(DequipDto dequipDto);

    //添加
    void addDequip(Dequip dequip);

    //修改前查询
    Dequip queryByCode(String code);
    void updateDequip(Dequip dequip);

    void deleteByCode(String code);
    int deleteByManyCode(String[] code);

}
