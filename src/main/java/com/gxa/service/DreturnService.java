package com.gxa.service;

import com.gxa.dto.DreturnDto;
import com.gxa.entity.Dreturn;
import com.gxa.entity.Dreview;

import java.util.List;

public interface DreturnService {
    List<Dreturn> queryAll(DreturnDto dreturnDto);

}
