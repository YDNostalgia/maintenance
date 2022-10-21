package com.gxa.service.impl;

import com.gxa.dto.WEquipManageQueryDto;
import com.gxa.dto.WequipManageAddDto;
import com.gxa.entity.*;
import com.gxa.mapper.*;
import com.gxa.service.WEquipManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WEquipManageServiceImpl implements WEquipManageService {

    @Autowired
    private WEquipManageMapper wEquipManageMapper;

    @Autowired
    private WFacilityClass2Mapper wFacilityClass2Mapper;

    @Autowired
    private WRegionMapper wRegionMapper;

    @Autowired
    private WFacilityUnitMapper wFacilityUnitMapper;

    @Autowired
    private WlocationXlaMapper wlocationXlaMapper;

    @Override
    public List<WFacilityManagement> queryAllWFacilityManagement() {
        List<WFacilityManagement> wFacilityManagements = this.wEquipManageMapper.queryAllWFacilityManagement();
        return wFacilityManagements;
    }

    @Override
    public List<WFacilityClass2> queryAllWfacilityClass2() {
        List<WFacilityClass2> wFacilityClass2s = this.wFacilityClass2Mapper.queryAllWfacilityClass2();
        return wFacilityClass2s;
    }

    @Override
    public List<WRegion> queryAllWregion() {
        List<WRegion> wRegions = this.wRegionMapper.queryAllWregion();
        return wRegions;
    }

    @Override
    public List<WFacilityManagement> queryAllWFacilityManagementNameList(WEquipManageQueryDto wEquipManageQueryDto) {
        String wEquipManagemhb = wEquipManageQueryDto.getWEquipManagemhb();

        try {
            Integer id = Integer.valueOf(wEquipManagemhb);
            wEquipManageQueryDto.setWEquipManageId(id);
            List<WFacilityManagement> wFacilityManagements = this.wEquipManageMapper.queryAllWFacilityManagementNameList(wEquipManageQueryDto);
            return wFacilityManagements;
        }catch (Exception e){
            e.printStackTrace();
            wEquipManageQueryDto.setWEquipManageName(wEquipManagemhb);
            List<WFacilityManagement> wFacilityManagements = this.wEquipManageMapper.queryAllWFacilityManagementNameList(wEquipManageQueryDto);
            return wFacilityManagements;
        }

    }

    @Override
    public List<WFacilityUnit> queryAllWfacilityUnit() {
        List<WFacilityUnit> wFacilityUnits = this.wFacilityUnitMapper.queryAllWfacilityUnit();
        return wFacilityUnits;
    }

    @Override
    public List<WLocation> queryByWregionId(Integer wRegionId) {
        List<WLocation> wLocations = this.wlocationXlaMapper.queryByWregionId(wRegionId);
        return wLocations;
    }

    @Override
    public void addWequipManage(WequipManageAddDto wequipManageAddDto) {
        this.wEquipManageMapper.addWequipManage(wequipManageAddDto);
    }

    @Override
    public WFacilityManagement queryByNumber(Integer number) {
        WFacilityManagement wFacilityManagement = this.wEquipManageMapper.queryByNumber(number);
        return wFacilityManagement;
    }

    @Override
    public void updateWequipManage(WequipManageAddDto wequipManageAddDto) {
        this.wEquipManageMapper.updateWequipManage(wequipManageAddDto);
    }

    @Override
    public void deleteWequipManage(List<Integer> numbers) {
        for(int i = 0;i < numbers.size();i++){
            Integer number = numbers.get(i);
            this.wEquipManageMapper.deleteWequipManage(number);
        }
    }
}
