package com.gxa.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
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
    public PageInfo<KeepPlan> queryAllKeepPlan(KeepPlanDto keepPlanDto,Integer page,Integer limit) {
        PageHelper.startPage(page,limit);
        List<KeepPlan> keepPlans = keepPlanMapper.queryAllKeepPlan(keepPlanDto);
        PageInfo<KeepPlan> pageInfo = new PageInfo<>(keepPlans);
        return pageInfo;
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
