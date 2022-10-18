package com.gxa.mapper;

import com.gxa.dto.PersonalMtorderDto;
import com.gxa.dto.PersonalMtorderListDto;
import com.gxa.entity.PersonalOrder;

import java.util.List;

public interface PersonalOrderMapper {
    public List<PersonalOrder> queryAllPersonalOrder();
    public List<PersonalOrder> queryAllPersonalOrderList(PersonalMtorderListDto personalMtorderListDto);
}
