package com.gxa.service.impl;

import com.gxa.entity.Statute;
import com.gxa.mapper.StatuteMapper;
import com.gxa.service.StatuteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatuteServiceImpl implements StatuteService {

    @Autowired
    private StatuteMapper statuteMapper;

    @Override
    /**
     * 查询所有法规
     */
    public List<Statute> queryAll() {
        List<Statute> statutes = this.statuteMapper.queryAll();
        return statutes;
    }
}
