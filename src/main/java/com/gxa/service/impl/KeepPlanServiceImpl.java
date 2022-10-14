package com.gxa.service.impl;

import com.gxa.dto.KeepPlanDto;
import com.gxa.entity.KeepPlan;
import com.gxa.entity.KeepPlanAU;
import com.gxa.mapper.KeepPlanMapper;
import com.gxa.service.KeepPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class KeepPlanServiceImpl implements KeepPlanService {

    @Autowired
    private KeepPlanMapper keepPlanMapper;
    @Override
    public List<KeepPlan> queryAllKeepPlan(KeepPlanDto keepPlanDto) {
        List<KeepPlan> keepPlans = keepPlanMapper.queryAllKeepPlan(keepPlanDto);
        return keepPlans;
    }

    @Override
    public int count(KeepPlanDto keepPlanDto) {
        int count = keepPlanMapper.count(keepPlanDto);
        return count;
    }

    @Override
    public void addKeepPlan(KeepPlanAU keepPlanAU) {
        keepPlanMapper.addKeepPlan(keepPlanAU);
    }

    @Override
    public void updateKeepPlan(KeepPlanAU keepPlanAU) {
        keepPlanMapper.updateKeepPlan(keepPlanAU);
    }

    @Override
    public void deleteKeepPlan(int id) {
        keepPlanMapper.deleteKeepPlan(id);
    }
}
