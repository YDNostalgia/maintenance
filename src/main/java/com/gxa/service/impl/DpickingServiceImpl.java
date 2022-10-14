package com.gxa.service.impl;

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
    public List<Dpicking> queryAll() {
        List<Dpicking> dpickings=this.dpickingMapper.queryAll();
        return dpickings;
    }

    @Override
    public List<Dreview> queryDreviews() {
        List<Dreview> dreviews=this.dreviewMapper.queryAll();
        return dreviews;
    }

    @Override
    public void add(Dpicking dpicking) {
        this.dpickingMapper.save(dpicking);
    }

    @Override
    public Dpicking queryById(Integer id) {
        Dpicking dpicking=this.dpickingMapper.queryById(id);
        return dpicking;
    }

    @Override
    public void update(Dpicking dpicking) {
        this.dpickingMapper.update(dpicking);
    }

    @Override
    public void delete(Integer id) {
        this.dpickingMapper.delete(id);
    }
}
