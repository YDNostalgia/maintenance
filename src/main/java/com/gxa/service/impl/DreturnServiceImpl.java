package com.gxa.service.impl;

import com.gxa.entity.Dreturn;
import com.gxa.mapper.DreturnMapper;
import com.gxa.service.DreturnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DreturnServiceImpl implements DreturnService {

    @Autowired
    private DreturnMapper dreturnMapper;


    @Override
    public List<Dreturn> selectList() {
        List<Dreturn> dreturns = this.dreturnMapper.queryDreturns();
        return dreturns;
    }
}
