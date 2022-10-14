package com.gxa.mapper;

import com.gxa.dto.DpickingDto;
import com.gxa.entity.Dpicking;

import java.util.List;

public interface DpickingMapper {
    List<Dpicking> queryAll(DpickingDto dpickingDto);

}