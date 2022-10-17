package com.gxa.service.impl;

import com.gxa.dto.DcountingDto;
import com.gxa.entity.Dcounting;
import com.gxa.entity.Dreview;
import com.gxa.mapper.DcountingMapper;
import com.gxa.mapper.DreviewMapper;
import com.gxa.service.DcountingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DcountingServiceImpl implements DcountingService {
    @Autowired
    private DcountingMapper dcountingMapper;
    private DreviewMapper dreviewMapper;

    @Override
    public List<Dcounting> queryAll(DcountingDto dcountingDto) {
        List<Dcounting> dcountings=this.dcountingMapper.queryAll(dcountingDto);
        return dcountings;
    }

    @Override
    public List<Dreview> queryDreviews() {
        List<Dreview> dreviews=this.dreviewMapper.queryAll();
        return dreviews;
    }

    @Override
    public void add(Dcounting dcounting) {
        this.dcountingMapper.save(dcounting);
    }

    @Override
    public Dcounting queryById(Integer id) {
        Dcounting dcounting=this.dcountingMapper.queryById(id);
        return dcounting;
    }

    @Override
    public void update(Dcounting dcounting) {
        this.dcountingMapper.update(dcounting);
    }

    @Override
    public void delete(Integer id) {
        this.dcountingMapper.delete(id);
    }
}