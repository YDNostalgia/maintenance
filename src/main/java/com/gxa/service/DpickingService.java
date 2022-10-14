package com.gxa.service;

import com.gxa.dto.DpickingDto;
import com.gxa.entity.Dpicking;
import com.gxa.entity.Dreview;

import java.util.List;

public interface DpickingService {
    List<Dpicking> queryAll(DpickingDto dpickingDto);

}
