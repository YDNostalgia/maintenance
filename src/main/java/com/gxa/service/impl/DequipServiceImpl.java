package com.gxa.service.impl;

import com.gxa.dto.DequipDto;
import com.gxa.entity.Dequip;
import com.gxa.mapper.DequipMapper;
import com.gxa.service.DequipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DequipServiceImpl implements DequipService {

    @Autowired
    private DequipMapper dequipMapper;


    @Override
    public List<Dequip> queryList(DequipDto dequipDto) {
        List<Dequip> dequips = this.dequipMapper.queryList(dequipDto);
        return dequips;
    }

}
