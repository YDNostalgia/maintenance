package com.gxa.service.impl;

import com.gxa.dto.DequipDto;
import com.gxa.entity.*;
import com.gxa.mapper.DecompanyMapper;
import com.gxa.mapper.DequipMapper;
import com.gxa.mapper.DesaveMapper;
import com.gxa.mapper.DetypeMapper;
import com.gxa.service.DequipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DequipServiceImpl implements DequipService {

    @Autowired
    private DequipMapper dequipMapper;

    @Autowired
    private DetypeMapper detypeMapper;

    @Autowired
    private DesaveMapper desaveMapper;

    @Autowired
    private DecompanyMapper decompanyMapper;

    @Override
    public List<Dequip> queryChooseList(DequipDto dequipDto) {
        List<Dequip> dequips = this.dequipMapper.queryChooseList(dequipDto);
        return dequips;
    }
    @Override
    public List<Detype> queryType() {
        List<Detype> detypes = this.detypeMapper.queryType();
        return detypes;
    }
    @Override
    public List<Desave> querySave() {
        List<Desave> desaves = this.desaveMapper.querySave();
        return desaves;
    }

    @Override
    public List<Decompany> queryCompany() {
        List<Decompany> decompanies = this.decompanyMapper.queryCompany();
        return decompanies;
    }

    @Override
    public DequipToAdd addDequip(DequipToAdd dequipToAdd) {
        this.dequipMapper.addDequip(dequipToAdd);

        if(dequipToAdd != null){
            return dequipToAdd;
        } else {
            return null;
        }
    }


}
