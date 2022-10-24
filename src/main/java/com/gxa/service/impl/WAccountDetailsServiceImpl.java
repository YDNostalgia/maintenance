package com.gxa.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.gxa.dto.*;
import com.gxa.entity.WAccountDetails;
import com.gxa.entity.WPickingManagement;
import com.gxa.mapper.WAccountDetailsMapper;
import com.gxa.mapper.WPickingDetailsMapper;
import com.gxa.mapper.WPickingManagementMapper;
import com.gxa.service.WAccountDetailsService;
import com.gxa.service.WPickingManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WAccountDetailsServiceImpl implements WAccountDetailsService {

    @Autowired
    private WAccountDetailsMapper wAccountDetailsMapper;

    @Override
    public List<Integer> queryByWfacilityManagementId(Integer wfacilityManagementId,Integer code) {
        List<Integer> receiptNos = wAccountDetailsMapper.queryByWfacilityManagementId(wfacilityManagementId,code);
        return receiptNos;
    }

    @Override
    public WAccountDetails queryByCondition(WAccountDetailsQueryDto wAccountDetailsQueryDto) {
        WAccountDetails wAccountDetails = wAccountDetailsMapper.queryByCondition(wAccountDetailsQueryDto);
        return wAccountDetails;
    }
}
