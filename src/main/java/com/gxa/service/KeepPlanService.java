package com.gxa.service;

import com.github.pagehelper.PageInfo;
import com.gxa.dto.KeepPlanDto;
import com.gxa.entity.KeepPlan;
import com.gxa.entity.KeepPlanAU;

import java.util.List;

public interface KeepPlanService {
    PageInfo<KeepPlan> queryAllKeepPlan(KeepPlanDto keepPlanDto,Integer page,Integer limit);

    void addKeepPlan(KeepPlanAU keepPlanAU);

    void updateKeepPlan(KeepPlanAU keepPlanAU);

    void deleteKeepPlan(int id);
}
