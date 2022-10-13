package com.gxa.service.impl;

import com.gxa.entity.Dwarehouse;
import com.gxa.mapper.DwarehouseMapper;
import com.gxa.service.DwarehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DwarehouseServiceImpl implements DwarehouseService {

    @Autowired
    private DwarehouseMapper dwarehouseMapper;


    @Override
    public List<Dwarehouse> queryDwarehouse() {
        List<Dwarehouse> dwarehouses = this.dwarehouseMapper.queryDwarehouse();
        return dwarehouses;
    }
}
