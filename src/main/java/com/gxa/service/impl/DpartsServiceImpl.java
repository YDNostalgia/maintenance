package com.gxa.service.impl;

import com.gxa.entity.Dparts;
import com.gxa.mapper.DpartsMapper;
import com.gxa.service.DpartsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DpartsServiceImpl implements DpartsService {

    @Autowired
    private DpartsMapper dpartsMapper;


    @Override
    public List<Dparts> queryList() {
        List<Dparts> dparts = this.dpartsMapper.queryList();
        return dparts;
    }
}
