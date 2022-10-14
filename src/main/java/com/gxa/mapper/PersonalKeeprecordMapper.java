package com.gxa.mapper;

import com.gxa.dto.PersonalMtorderDto;
import com.gxa.entity.KeepRecord;

import java.util.List;

public interface PersonalKeeprecordMapper {
    public List<KeepRecord> queryAllKeeprecord();
    public List<KeepRecord> queryAllKeeprecordList(PersonalMtorderDto personalMtorderDto);
}
