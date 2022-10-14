package com.gxa.service;

import com.gxa.dto.KeepPlanDto;
import com.gxa.entity.KeepPlan;
import com.gxa.entity.KeepPlanAU;

import java.util.List;

public interface KeepPlanService {
    List<KeepPlan> queryAllKeepPlan(KeepPlanDto keepPlanDto);
    int count(KeepPlanDto keepPlanDto);

    void addKeepPlan(KeepPlanAU keepPlanAU);

    void updateKeepPlan(KeepPlanAU keepPlanAU);

    void deleteKeepPlan(int id);
}
