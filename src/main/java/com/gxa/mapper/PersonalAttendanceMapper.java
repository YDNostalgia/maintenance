package com.gxa.mapper;

import com.gxa.dto.PersonalAttendanceDto;
import com.gxa.entity.PersonalAttendance;

import java.util.List;

public interface PersonalAttendanceMapper {
    public List<PersonalAttendance> queryAllPersonalAttendance();
    public List<PersonalAttendance> queryAllPersonalAttendanceList(PersonalAttendanceDto personalAttendanceDto);
}
