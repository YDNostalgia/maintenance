package com.gxa.mapper;

import com.gxa.dto.PersonalQueryDto;
import com.gxa.entity.Personal;

import java.util.List;

public interface PersonalMapper {
    public List<Personal> queryAllPersonal();
    public List<Personal> queryAllPersonalList(PersonalQueryDto personalQueryDto);
    public void addPersonal(Personal personal);
    public Personal queryByPersonalId(Integer id);
    public void updatePersonal(Personal personal);
    public void deletePersonal(Integer id);
}
