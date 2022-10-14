package com.gxa.service.impl;

import com.gxa.dto.DpickingDto;
import com.gxa.entity.Dpicking;
import com.gxa.entity.Dreview;
import com.gxa.mapper.DpickingMapper;
import com.gxa.mapper.DreviewMapper;
import com.gxa.service.DpickingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DpickingServiceImpl implements DpickingService {

    @Autowired
    private DpickingMapper dpickingMapper;
    private DreviewMapper dreviewMapper;

    @Override
    public List<Dpicking> queryAll(DpickingDto dpickingDto) {
        List<Dpicking> dpickings=this.dpickingMapper.queryAll(dpickingDto);
        return dpickings;
    }


}
