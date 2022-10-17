package com.gxa.service.impl;

import com.gxa.dto.DwarehouseDto;
import com.gxa.entity.Dequip;
import com.gxa.entity.Dreview;
import com.gxa.entity.Dwarehouse;
import com.gxa.mapper.DequipMapper;
import com.gxa.mapper.DreviewMapper;
import com.gxa.mapper.DwarehouseMapper;
import com.gxa.service.DwarehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DwarehouseServiceImpl implements DwarehouseService {

    @Autowired
    private DwarehouseMapper dwarehouseMapper;
    @Autowired
    private DreviewMapper dreviewMapper;
    @Autowired
    private DequipMapper dequipMapper;

    @Override
    public List<Dwarehouse> queryDwarehouse(DwarehouseDto dwarehouseDto) {
        List<Dwarehouse> dwarehouses = this.dwarehouseMapper.queryDwarehouse(dwarehouseDto);
        return dwarehouses;
    }

    @Override
    public List<Dreview> queryDreview(Dreview dreview) {
        List<Dreview> dreviews=this.dreviewMapper.queryAll();
        return dreviews;
    }

    @Override
    public List<Dequip> queryDequip(Dequip dequip) {
        List<Dequip> dequips=this.dequipMapper.queryChooseList();
        return dequips;
    }

    @Override
    public Dwarehouse addDwarehouse(Dwarehouse dwarehouse) {
        this.dwarehouseMapper.addDwarehouse(dwarehouse);
        return dwarehouse;
    }

    @Override
    public void updateDwarehouse(Dwarehouse dwarehouse) {
        this.dwarehouseMapper.updateDwarehouser(dwarehouse);
    }

    @Override
    public void deleteDwarehouse(Integer id) {
        this.dwarehouseMapper.deleteDwarehouse(id);

    }
}
