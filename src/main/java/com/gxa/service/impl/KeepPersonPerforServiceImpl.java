package com.gxa.service.impl;

import com.gxa.entity.KeepPersonPerfor;
import com.gxa.mapper.KeepPersonPerforMapper;
import com.gxa.service.KeepPersonPerforService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class KeepPersonPerforServiceImpl implements KeepPersonPerforService {
    @Autowired
    private KeepPersonPerforMapper keepPersonPerforMapper;

    @Override
    public List<KeepPersonPerfor> queryKeepPersonPerfor() {
        List<KeepPersonPerfor> keepPersonPerfors = keepPersonPerforMapper.queryKeepPersonPerfor();
        return keepPersonPerfors;
    }
}
