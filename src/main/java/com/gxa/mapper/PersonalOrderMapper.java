package com.gxa.mapper;

import com.gxa.dto.PersonalMtorderDto;
import com.gxa.dto.PersonalMtorderListDto;
import com.gxa.entity.PersonalOrder;

import java.util.List;

public interface PersonalOrderMapper {
    public List<PersonalOrder> queryAllPersonalOrder();
    public List<PersonalOrder> queryAllPersonalOrderList(PersonalMtorderListDto personalMtorderListDto);
    //根据条件查询出所有有维修任务的人员的Id和维修任务量
    public List<PersonalOrder> queryIdAndOrders(PersonalMtorderListDto personalMtorderListDto);
}
