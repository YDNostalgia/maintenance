package com.gxa.mapper;

import com.gxa.dto.StatuteTypeEditDto;
import com.gxa.entity.StatuteType;

import java.util.List;

public interface StatuteTypeMapper {
    List<StatuteType>  queryAll();
    void add(String statuteTypeName);
    void save(StatuteTypeEditDto statuteTypeEditDto);
    void delete(Integer statuteTypeId);
}
