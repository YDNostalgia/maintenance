package com.gxa.service.impl;

import com.gxa.entity.Dlocaltion;
import com.gxa.mapper.DlocaltionMapper;
import com.gxa.service.DlocaltionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DlocaltionServiceImpl implements DlocaltionService {

    @Autowired
    private DlocaltionMapper dlocaltionMapper;


    @Override
    public List<Dlocaltion> selectList() {
        List<Dlocaltion> equipmentDatas = this.dlocaltionMapper.queryList();
        return equipmentDatas;
    }
}
