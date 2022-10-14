package com.gxa.mapper;

import com.gxa.dto.DwarehouseDto;
import com.gxa.entity.Dwarehouse;

import java.util.List;

public interface DwarehouseMapper {
    List<Dwarehouse> queryDwarehouse(DwarehouseDto dwarehouseDto);
}
