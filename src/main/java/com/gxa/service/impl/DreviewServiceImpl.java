package com.gxa.service.impl;

import com.gxa.entity.Dreview;
import com.gxa.mapper.DreviewMapper;
import com.gxa.service.DreviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DreviewServiceImpl implements DreviewService {
    @Autowired
    private DreviewMapper dreviewMapper;

    @Override
    public List<Dreview> queryAll() {
        List<Dreview> dreviews=this.dreviewMapper.queryAll();
        return dreviews;
    }
}
