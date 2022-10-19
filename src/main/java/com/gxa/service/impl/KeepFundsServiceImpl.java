package com.gxa.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.gxa.dto.KeepPlanDto;
import com.gxa.entity.KeepFunds;
import com.gxa.entity.KeepFundsAU;
import com.gxa.mapper.KeepFundsMapper;
import com.gxa.service.KeepFundsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class KeepFundsServiceImpl implements KeepFundsService {
    @Autowired
    private KeepFundsMapper keepFundsMapper;

    @Override
    public PageInfo<KeepFunds> queryAllKeepFunds(KeepPlanDto keepPlanDto,Integer page,Integer limit) {
        PageHelper.startPage(page,limit);
        List<KeepFunds> keepFunds = keepFundsMapper.queryAllKeepFunds(keepPlanDto);
        PageInfo<KeepFunds> pageInfo  = new PageInfo<>(keepFunds);
        return pageInfo;
    }

    @Override
    public void addKeepFunds(KeepFundsAU keepFundsAU) {
        keepFundsMapper.addKeepFunds(keepFundsAU);
    }

    @Override
    public void updateKeepFunds(KeepFundsAU keepFundsAU) {
        keepFundsMapper.updateKeepFunds(keepFundsAU);
    }

    @Override
    public void deleteKeepFunds(Integer id) {
        keepFundsMapper.deleteKeepFunds(id);
    }
}
