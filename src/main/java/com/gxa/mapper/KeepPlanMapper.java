package com.gxa.mapper;

import com.gxa.dto.KeepPlanDto;
import com.gxa.entity.KeepPlan;
import com.gxa.entity.KeepPlanAU;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface KeepPlanMapper {
    List<KeepPlan> queryAllKeepPlan(KeepPlanDto keepPlanDto);

    int count(KeepPlanDto keepPlanDto);

    void addKeepPlan(KeepPlanAU keepPlanAU);

    void updateKeepPlan(KeepPlanAU keepPlanAU);

    void deleteKeepPlan(int id);
}
