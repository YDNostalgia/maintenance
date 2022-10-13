package com.gxa.service;

import com.gxa.dto.DequipDto;
import com.gxa.entity.Dequip;

import java.util.List;

public interface DequipService {
    List<Dequip> queryList(DequipDto dequipDto);
}
