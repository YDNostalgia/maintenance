package com.gxa.controller;

import com.gxa.dto.WlocationAddDto;
import com.gxa.dto.WlocationUpdateDto;
import com.gxa.entity.WLocation;
import com.gxa.entity.WRegion;
import com.gxa.entity.WStore;
import com.gxa.service.WStoreService;
import com.gxa.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Api(tags = "W-货位信息接口")
public class WStoreController {

    @Autowired
    private WStoreService wStoreService;

    @GetMapping(value = "/dlocaltion/list")
    @ApiOperation(value = "货位信息-信息列表")
    public Result<List<WStore>> goodsAllocationList(){

        Result<List<WStore>> result = Result.failed("货位信息拉取失败！");

        try {
            List<WStore> wStores = this.wStoreService.queryAllWLocation();
            System.out.println("输出最终结果：" + wStores);
            Integer size = wStores.size();
            Long total = size.longValue();

            result = Result.success(wStores,total);
        }catch (Exception e){
            e.printStackTrace();
        }

        return result;
    }

    @PostMapping(value = "/dlocaltion/add")
    @ApiOperation(value = "货位信息-区域添加")
    public Result addWregion(String wRegionName){
        System.out.println("输出添加区域 "+ wRegionName);
        Result result = Result.failed("添加区域信息失败！");

        try {
            this.wStoreService.addWregion(wRegionName);
            result = Result.success();
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }

    @PostMapping(value = "/wlocation/add")
    @ApiOperation(value = "货位信息-区域内货位添加")
    public Result addWlocation(@RequestBody(required = false) WlocationAddDto wlocationAddDto){
        System.out.println("输出添加的货位信息： " + wlocationAddDto);
        Result result = Result.failed("区域内货位添加失败！");

        try {
            this.wStoreService.addWlocation(wlocationAddDto);
            result = Result.success();
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }

    @PostMapping(value = "/dlocaltion/updateWregionName")
    @ApiOperation(value = "货位信息-修改区域名称")
    public Result updateWregion(@RequestBody WRegion wRegion){
        System.out.println("输出修改区域名称信息： " + wRegion);
        Result result = Result.failed("修改区域名称失败！");

        try {
            this.wStoreService.updateWregionName(wRegion);
            result = Result.success();
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }

    @PostMapping(value = "/dlocaltion/updateWlocationName")
    @ApiOperation(value = "货位信息-修改区域内货位名称")
    public Result updateWlocation(@RequestBody WlocationUpdateDto wlocationUpdateDto){
        System.out.println("输出修改区域内货位名称信息：" + wlocationUpdateDto);
        Result result = Result.failed("修改区域内货位名称失败！");
        try {
            this.wStoreService.updateWlocationName(wlocationUpdateDto);
            result = Result.success();
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }

    @GetMapping(value = "/dlocaltion/deleteWregion")
    @ApiOperation(value = "货位信息-删除区域信息")
    public Result deleteWregion(Integer wRegionId){
        System.out.println("删除区域的id为：" + wRegionId);
        Result result = Result.failed();
        try {
            List<WStore> wStores = this.wStoreService.queryAllWLocation();
//            System.out.println("输出所有区域： " + wStores);
            WStore wStore = wStores.get(wRegionId - 1);
//            System.out.println("输出要删除的区域信息： " + wStore);
            int count = wStore.getCount();
//            System.out.println("要删除的区域的count值为：" + count);

            if(count > 0){
                result = Result.failed("该区域内存有货物，不能删除！");
            }else if(wStore.getCount() == 0){
                this.wStoreService.deleteWregion(wRegionId);
                result = Result.success();
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return result;
    }

    @PostMapping(value = "/dlocaltion/deleteWlocation")
    @ApiOperation(value = "货位信息-删除区域内货位信息")
    public Result deleteWlocation(@RequestBody String wLocationName){
        System.out.println("删除的货位名称为：" + wLocationName);
        Result result = Result.failed();
        try {
            List<WLocation> wLocations = this.wStoreService.queryWLocationQuantity();
            System.out.println("输出所有货位对应的货物数： " + wLocations);

            for(int i = 0;i < wLocations.size();i++){
                WLocation wLocation = wLocations.get(i);
                String name = wLocation.getName();
                Integer count = wLocation.getCount();

                if(wLocationName.equals(name) && count > 0){
                    result = Result.failed("该货位内存有货物，不能删除！");
                } else if(wLocationName.equals(name) && count == 0){
                    this.wStoreService.deleteWlocation(wLocationName);
                    result = Result.success();
                }
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }
}
