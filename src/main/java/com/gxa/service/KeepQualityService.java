package com.gxa.service;

import com.github.pagehelper.PageInfo;
import com.gxa.dto.KeepPlanDto;
import com.gxa.entity.KeepQuality;
import com.gxa.entity.KeepQualityAU;

public interface KeepQualityService {
    PageInfo<KeepQuality> queryAllKeepQuality(KeepPlanDto keepPlanDto,Integer page,Integer limit);
    void addKeepQuality(KeepQualityAU keepQualityAU);

    void updateKeepQuality(KeepQualityAU keepQualityAU);

    void deleteKeepQuality(Integer id);

}
