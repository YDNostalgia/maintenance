package com.gxa.mapper;

import com.gxa.dto.DreturnDto;
import com.gxa.entity.Dreturn;

import java.util.List;

public interface DreturnMapper {
    List<Dreturn> queryAll(DreturnDto dreturnDto);

}
