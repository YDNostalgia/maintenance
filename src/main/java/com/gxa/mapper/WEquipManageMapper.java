package com.gxa.mapper;

import com.gxa.dto.WEquipManageQueryDto;
import com.gxa.dto.WequipManageAddDto;
import com.gxa.entity.WFacilityManagement;

import java.util.List;

public interface WEquipManageMapper {
    public List<WFacilityManagement> queryAllWFacilityManagement();
    public List<WFacilityManagement> queryAllWFacilityManagementNameList(WEquipManageQueryDto wEquipManageQueryDto);
    public void addWequipManage(WequipManageAddDto wequipManageAddDto);
    public WFacilityManagement queryByNumber(Integer number);
    public void updateWequipManage(WequipManageAddDto wequipManageAddDto);
    public void deleteWequipManage(Integer number);
}
