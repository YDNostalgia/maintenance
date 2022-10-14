package com.gxa.service;

import com.gxa.dto.DwarehouseDto;
import com.gxa.entity.Dwarehouse;

import java.util.List;

public interface DwarehouseService {
    List<Dwarehouse> queryDwarehouse(DwarehouseDto dwarehouseDto);
}
