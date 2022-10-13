package com.gxa.service.impl;

import com.gxa.entity.Dreturn;
import com.gxa.entity.Dreview;
import com.gxa.mapper.DreturnMapper;
import com.gxa.mapper.DreviewMapper;
import com.gxa.service.DreturnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DreturnServiceImpl implements DreturnService {

    @Autowired
    private DreviewMapper dreviewMapper;
    private DreturnMapper dreturnMapper;

    @Override
    public List<Dreturn> queryAll() {
        List<Dreturn> dreturns=this.dreturnMapper.queryAll();
        return dreturns;
    }

    @Override
    public List<Dreview> queryDreviews() {
        List<Dreview> dreviews=this.dreviewMapper.queryAll();
        return dreviews;
    }

    @Override
    public void add(Dreturn dreturn) {
        this.dreturnMapper.save(dreturn);
    }

    @Override
    public Dreturn queryById(Integer id) {
        Dreturn dreturn=this.dreturnMapper.queryById(id);
        return null;
    }

    @Override
    public void update(Dreturn dreturn) {
        this.dreturnMapper.update(dreturn);
    }

    @Override
    public void delete(Integer id) {
        this.dreturnMapper.delete(id);
    }
}
