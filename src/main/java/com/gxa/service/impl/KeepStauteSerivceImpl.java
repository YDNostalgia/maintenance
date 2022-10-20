package com.gxa.service.impl;

import com.gxa.entity.KeepStaute;
import com.gxa.mapper.KeepStauteMapper;
import com.gxa.service.KeepStauteSerivce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class KeepStauteSerivceImpl implements KeepStauteSerivce {
    @Autowired
    private KeepStauteMapper keepStauteMapper;
    @Override
    public List<KeepStaute> queryAllKeepStaute() {
        List<KeepStaute> keepStautes = keepStauteMapper.queryAllKeepStaute();
        return keepStautes;
    }
}
