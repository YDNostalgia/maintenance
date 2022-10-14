package com.gxa.service;

import com.github.pagehelper.PageInfo;
import com.gxa.dto.StatuteAddDto;
import com.gxa.dto.StatuteEditDto;
import com.gxa.dto.StatuteQueryDto;
import com.gxa.entity.Statute;

import java.util.List;

public interface StatuteService {
    PageInfo<Statute> queryByIdAndName(StatuteQueryDto statuteQueryDto);
    void add(StatuteAddDto statuteAddDto);
    void update(StatuteEditDto statuteEditDto);
}
