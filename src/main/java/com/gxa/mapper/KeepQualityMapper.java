package com.gxa.mapper;

import com.gxa.dto.KeepPlanDto;
import com.gxa.entity.KeepQuality;
import com.gxa.entity.KeepQualityAU;

import java.util.List;

public interface KeepQualityMapper {
    List<KeepQuality> queryAllKeepQuality(KeepPlanDto keepPlanDto);

    void addKeepQuality(KeepQualityAU keepQualityAU);

    void updateKeepQuality(KeepQualityAU keepQualityAU);

    void deleteKeepQuality(Integer id);
}
