package com.gxa.service;


import com.gxa.dto.WlocationAddDto;
import com.gxa.dto.WlocationUpdateDto;
import com.gxa.entity.WLocation;
import com.gxa.entity.WRegion;
import com.gxa.entity.WStore;

import java.util.List;

public interface WStoreService {
    //查询出所有货架和区域的对应关系
    public List<WStore> queryAllWLocation();
    //添加货位区域
    public void addWregion(String wRegionName);
    //添加区域内货位信息
    public void addWlocation(WlocationAddDto wlocationAddDto);
    //修改区域名称
    public void updateWregionName(WRegion wRegion);
    //修改区域内货位名称
    public void updateWlocationName(WlocationUpdateDto wlocationUpdateDto);
    //根据区域id删除该区域
    public void deleteWregion(Integer wRegionId);
    //查询所有货位存放的货物数
    public List<WLocation> queryWLocationQuantity();
    //根据货位名称删除货位
    public void deleteWlocation(String wLocationName);

}
