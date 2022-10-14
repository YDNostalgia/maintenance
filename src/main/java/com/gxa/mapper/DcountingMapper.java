package com.gxa.mapper;

import com.gxa.dto.DcountingDto;
import com.gxa.entity.Dcounting;

import java.util.List;

public interface DcountingMapper {
    List<Dcounting> queryAll(DcountingDto dcountingDto);

    void save(Dcounting dcounting);
    Dcounting queryById(Integer id);

    void update(Dcounting dcounting);
    void delete(Integer id);
}
