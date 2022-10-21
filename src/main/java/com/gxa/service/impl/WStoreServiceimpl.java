package com.gxa.service.impl;

import com.gxa.dto.WlocationAddDto;
import com.gxa.dto.WlocationUpdateDto;
import com.gxa.entity.WLocation;
import com.gxa.entity.WRegion;
import com.gxa.entity.WStore;
import com.gxa.mapper.WLocationMapper;
import com.gxa.service.WStoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class WStoreServiceimpl implements WStoreService {

    @Autowired
    private WLocationMapper wLocationMapper;

    @Override
    public List<WStore> queryAllWLocation() {

        //new一个List<WStore>集合
        List<WStore> wStores = new ArrayList<>();

        //查询出所有货架和区域的对应关系
        List<WLocation> wLocations = this.wLocationMapper.queryAllWLocation();
//        System.out.println("service层输出货架区域： " + wLocations);

        //查询出所有货架存放货物的数量
        List<WLocation> wLocationsQuantity = this.wLocationMapper.queryWLocationQuantity();
//        System.out.println("Service层输出货架数量： " + wLocationsQuantity);

        //查询出所有的区域
        List<WRegion> wRegions = this.wLocationMapper.queryALLWregion();
//        System.out.println("Service层输出所有区域： " + wRegions);

        for(int i = 0;i < wLocations.size();i++){
            WLocation wLocation = wLocations.get(i);
            for(int j = 0;j < wLocationsQuantity.size();j++){
                WLocation wLocationq = wLocationsQuantity.get(j);
                if(wLocation.getName().equals(wLocationq.getName())){
                    Integer count = wLocationq.getCount();
                    wLocation.setCount(count);
                }
            }
        }

//        System.out.println("service层输出整合后货架和货位数对应关系： " + wLocations);

        for(int i = 0;i < wRegions.size();i++){
            WStore wStore = new WStore();
            WRegion wRegion = wRegions.get(i);
            Integer id = wRegion.getId();
            String name = wRegion.getName();

            wStore.setId(id);
            wStore.setName(name);
            List<WLocation> wLocationslist = new ArrayList<>();
            int count = 0;
            for (int j = 0;j < wLocations.size();j++){
                WLocation wLocationj = wLocations.get(j);
                if(wRegion.getId() == wLocationj.getRegion().getId()){
                    wLocationslist.add(wLocationj);
                    count = count + wLocationj.getCount();
                }
            }
            wStore.setCount(count);
            wStore.setWLocations(wLocationslist);

            wStores.add(wStore);
        }
//        System.out.println("service层输出整合后区域---货架和货位数对应关系： " + wStores);

        return wStores;
    }

    @Override
    public void addWregion(String wRegionName) {
        this.wLocationMapper.addWregion(wRegionName);
    }

    @Override
    public void addWlocation(WlocationAddDto wlocationAddDto) {
        this.wLocationMapper.addWlocation(wlocationAddDto);
    }

    @Override
    public void updateWregionName(WRegion wRegion) {
        this.wLocationMapper.updateWregionName(wRegion);
    }

    @Override
    public void updateWlocationName(WlocationUpdateDto wlocationUpdateDto) {
        this.wLocationMapper.updateWlocationName(wlocationUpdateDto);
    }

    @Override
    public void deleteWregion(Integer wRegionId) {
        this.wLocationMapper.deleteWregion(wRegionId);
    }

    @Override
    public List<WLocation> queryWLocationQuantity() {
        List<WLocation> wLocations = this.wLocationMapper.queryWLocationQuantity();
        return wLocations;
    }

    @Override
    public void deleteWlocation(String wLocationName) {
        this.wLocationMapper.deleteWlocation(wLocationName);
    }
}
