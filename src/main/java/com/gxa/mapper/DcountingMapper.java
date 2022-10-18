package com.gxa.mapper;

import com.gxa.dto.DcountingDto;
import com.gxa.entity.Dcounting;
import com.gxa.entity.DcountingSelect;

import java.util.List;

public interface DcountingMapper {
    List<Dcounting> queryAll(DcountingDto dcountingDto);

    List<Dcounting> queryByEquip(DcountingSelect dcountingSelect);
    void addCounting(Dcounting dcounting);
    Dcounting queryById(Integer id);

    void update(Dcounting dcounting);
    void delete(Integer id);
}
