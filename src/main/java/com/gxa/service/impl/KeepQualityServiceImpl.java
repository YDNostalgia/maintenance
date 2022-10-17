package com.gxa.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.gxa.dto.KeepPlanDto;
import com.gxa.entity.KeepQuality;
import com.gxa.entity.KeepQualityAU;
import com.gxa.mapper.KeepQualityMapper;
import com.gxa.service.KeepQualityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class KeepQualityServiceImpl implements KeepQualityService {

    @Autowired
    private KeepQualityMapper keepQualityMapper;
    @Override
    public PageInfo<KeepQuality> queryAllKeepQuality(KeepPlanDto keepPlanDto, Integer page, Integer limit) {
        PageHelper.startPage(page,limit);
        List<KeepQuality> keepQualities = keepQualityMapper.queryAllKeepQuality(keepPlanDto);
        PageInfo<KeepQuality> pageInfo = new PageInfo<>(keepQualities);
        return pageInfo;
    }

    @Override
    public void addKeepQuality(KeepQualityAU keepQualityAU) {
        keepQualityMapper.addKeepQuality(keepQualityAU);
    }

    @Override
    public void updateKeepQuality(KeepQualityAU keepQualityAU) {
        keepQualityMapper.updateKeepQuality(keepQualityAU);
    }

    @Override
    public void deleteKeepQuality(Integer id) {
        keepQualityMapper.deleteKeepQuality(id);
    }
}
