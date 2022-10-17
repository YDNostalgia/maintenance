package com.gxa.mapper;

import com.gxa.dto.DequipDto;
import com.gxa.entity.Dequip;

import java.util.List;

public interface DequipMapper {
    //查询列表页 分页 条件
    List<Dequip> queryChooseList(DequipDto dequipDto);


}
