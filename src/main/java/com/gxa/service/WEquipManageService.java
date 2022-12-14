package com.gxa.service;

import com.gxa.dto.WEquipManageQueryDto;
import com.gxa.dto.WequipManageAddDto;
import com.gxa.entity.*;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface WEquipManageService {
    //查询所有器材名称
    public List<String> queryAllName();
    //根据器材名称查询所有型号
    public List<String> queryByName(@Param("facilityName") String facilityName);
    //根据器材名称和型号查询器材编号
    public Integer queryByNameAndModel(@Param("facilityName") String facilityName,@Param("facilityModel") String facilityModel);
    //无条件拉取所有器材管理列表信息
    public List<WFacilityManagement> queryAllWFacilityManagement();
    //查询器材分类下拉框
    public List<WFacilityClass2> queryAllWfacilityClass2();
    //查询存放区域下拉框
    public List<WRegion> queryAllWregion();
    //按条件拉取所有器材管理列表信息
    public List<WFacilityManagement> queryAllWFacilityManagementNameList(WEquipManageQueryDto wEquipManageQueryDto);
    //查询器材单位下拉框
    public List<WFacilityUnit> queryAllWfacilityUnit();
    //根据区域id，查询该区域下所有货架
    public List<WLocation> queryByWregionId(Integer wRegionId);
    //新增器材
    public void addWequipManage(WequipManageAddDto wequipManageAddDto);
    //修改器材信息前数据回显
    public WFacilityManagement queryByNumber(Integer number);
    //根据器材编号修改器材信息
    public void updateWequipManage(WequipManageAddDto wequipManageAddDto);
    //根据器材编号批量删除器材信息
    public void deleteWequipManage(List<Integer> numbers);

}
