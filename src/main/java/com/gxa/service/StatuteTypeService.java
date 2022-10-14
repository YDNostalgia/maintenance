package com.gxa.service;

import com.github.pagehelper.PageInfo;
import com.gxa.dto.StatuteTypeEditDto;
import com.gxa.dto.StatuteTypeQueryDto;
import com.gxa.entity.StatuteType;


public interface StatuteTypeService {
    PageInfo<StatuteType> queryAll(StatuteTypeQueryDto statuteTypeQueryDto);
    void add(String statuteTypeName);
    void update(StatuteTypeEditDto statuteTypeEditDto);
    void delete(Integer statuteTypeId);
}
