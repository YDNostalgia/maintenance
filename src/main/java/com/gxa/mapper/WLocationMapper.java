package com.gxa.mapper;

import com.gxa.dto.WlocationAddDto;
import com.gxa.dto.WlocationUpdateDto;
import com.gxa.entity.WLocation;
import com.gxa.entity.WRegion;

import java.util.List;

public interface WLocationMapper {
    //查询出所有货架和区域的对应关系
    public List<WLocation> queryAllWLocation();
    //查询出所有货架存放货物的数量
    public List<WLocation> queryWLocationQuantity();
    //查询出所有的区域
    public List<WRegion> queryALLWregion();
    //添加区域
    public void addWregion(String wRegionName);
    //添加区域内货架
    public void addWlocation(WlocationAddDto wlocationAddDto);
    //修改区域名称
    public void updateWregionName(WRegion wRegion);
    //修改区域内货位名称
    public void updateWlocationName(WlocationUpdateDto wlocationUpdateDto);
    //根据区域id删除该区域
    public void deleteWregion(Integer wRegionId);
    //根据货位名称删除货位
    public void deleteWlocation(String wLocationName);
}
