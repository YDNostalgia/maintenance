package com.gxa.service.impl;

import com.gxa.dto.DreturnDto;
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
    private DreturnMapper dreturnMapper;

    @Override
    public List<Dreturn> queryAll(DreturnDto dreturnDto) {
        List<Dreturn> dreturns=this.dreturnMapper.queryAll(dreturnDto);
        return dreturns;
    }

}
