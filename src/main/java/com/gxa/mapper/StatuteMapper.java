package com.gxa.mapper;

import com.gxa.dto.StatuteAddDto;
import com.gxa.dto.StatuteEditDto;
import com.gxa.dto.StatuteQueryDto;
import com.gxa.entity.Statute;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StatuteMapper {
    List<Statute> queryByIdAndName(@Param("statuteName") String statuteName,@Param("statuteTypeId") Integer statuteTypeId);
    void add(StatuteAddDto statuteAddDto);
    void update(StatuteEditDto statuteEditDto);
}
