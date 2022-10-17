package com.gxa.service;

import com.github.pagehelper.PageInfo;
import com.gxa.dto.KeepPlanDto;
import com.gxa.entity.KeepFunds;
import com.gxa.entity.KeepFundsAU;

import java.util.List;

public interface KeepFundsService {
    PageInfo<KeepFunds> queryAllKeepFunds(KeepPlanDto keepPlanDto,Integer page,Integer limit);

    void addKeepFunds(KeepFundsAU keepFundsAU);
}
