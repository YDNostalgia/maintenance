package com.gxa.service.impl;

import com.gxa.entity.Dpicking;
import com.gxa.mapper.DpickingMapper;
import com.gxa.service.DpickingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DpickingServiceImpl implements DpickingService {

    @Autowired
    private DpickingMapper dpickingMapper;

    @Override
    public List<Dpicking> selectList() {
        List<Dpicking> dpickings = this.dpickingMapper.queryPickings();
        return dpickings;
    }
}
