package com.gxa.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.gxa.dto.WEquipManageQueryDto;
import com.gxa.dto.WequipManageAddDto;
import com.gxa.entity.*;
import com.gxa.service.WEquipManageService;
import com.gxa.utils.R;
import com.gxa.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Api(tags = "W-器材管理接口")
public class WEquipManageController {

    @Autowired
    private WEquipManageService wEquipManageService;

    @PostMapping(value = "/wFacilityManagement/list")
    @ApiOperation(value = "器材管理-器材管理列表/搜索")
    public Result<List<WFacilityManagement>> wFacilityManagementList(@RequestBody(required = false) WEquipManageQueryDto wEquipManageQueryDto){
        System.out.println("条件查询信息为： " + wEquipManageQueryDto);
        Integer page = wEquipManageQueryDto.getPage();
        Integer limit = wEquipManageQueryDto.getLimit();
        System.out.println("page-->" + page + "--limit-->" + limit);

        Result<List<WFacilityManagement>> result = Result.failed("拉取器材管理配件列表信息失败！");

//        try {
            //实现分页
            PageHelper.startPage(page,limit);
//            List<WFacilityManagement> wFacilityManagements = this.wEquipManageService.queryAllWFacilityManagement();
            List<WFacilityManagement> wFacilityManagements = this.wEquipManageService.queryAllWFacilityManagementNameList(wEquipManageQueryDto);
            PageInfo<WFacilityManagement> pageInfo = new PageInfo<>(wFacilityManagements);
            long total = pageInfo.getTotal();

            result = Result.success(wFacilityManagements,total);
//        }catch (Exception e){
//            e.printStackTrace();
//        }
        return result;
    }

    @GetMapping(value = "/wFacilityClass2/list")
    @ApiOperation(value = "器材管理-器材分类下拉框")
    public Result<List<WFacilityClass2>> queryPartsList(){
        Result<List<WFacilityClass2>> result = Result.failed("器材分类下拉框信息拉取失败！");

        try {
            List<WFacilityClass2> wFacilityClass2s = this.wEquipManageService.queryAllWfacilityClass2();
            Integer size = wFacilityClass2s.size();
            Long total = size.longValue();
            result = Result.success(wFacilityClass2s,total);
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }

    @GetMapping(value = "/wRegion/list")
    @ApiOperation(value = "器材管理-存放区域下拉框")
    public Result<List<WRegion>> queryWregionList(){
        Result<List<WRegion>> result = Result.failed("存放区域下拉框信息拉取失败！");

        try {
            List<WRegion> wRegions = this.wEquipManageService.queryAllWregion();
            Integer size = wRegions.size();
            Long total = size.longValue();
            result = Result.success(wRegions,total);
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }

    @GetMapping(value = "/wFacilityUnit/list")
    @ApiOperation(value = "器材管理-单位下拉框")
    public Result<List<WFacilityUnit>> queryWfacilityUnitList(){
        Result<List<WFacilityUnit>> result = Result.failed("器材单位下拉框信息拉取失败！");

        try {
            List<WFacilityUnit> wFacilityUnits = this.wEquipManageService.queryAllWfacilityUnit();
            Integer size = wFacilityUnits.size();
            Long total = size.longValue();

            result = Result.success(wFacilityUnits,total);
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }

    @GetMapping(value = "/queryWlocation/list")
    @ApiOperation(value = "器材管理-根据存放区域获取货架编号下拉框")
    public Result<List<WLocation>> queryWlocationList(Integer wRegionId){
        Result<List<WLocation>> result = Result.failed("拉取货架编号信息失败！");

        try {
            List<WLocation> wLocations = this.wEquipManageService.queryByWregionId(wRegionId);
            Integer size = wLocations.size();
            Long total = size.longValue();

            result = Result.success(wLocations,total);
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }

    @PostMapping(value = "/wEquipManage/add")
    @ApiOperation(value = "器材管理-新增器材")
    public Result addWequipManage(@RequestBody WequipManageAddDto wequipManageAddDto){
        System.out.println("新增器材的信息为： " + wequipManageAddDto);
        Result result = Result.failed("新增器材失败，仓库中存有该编号器材，请修改编号！");

        try {
            this.wEquipManageService.addWequipManage(wequipManageAddDto);
            result = Result.success();
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }

    @GetMapping(value = "/wEquipManage/updatePre")
    @ApiOperation(value = "器材管理-修改器材信息前数据回显")
    public Result updateWequipManagePre(Integer number){
        System.out.println("修改器材信息的编号为 ：" + number);
        Result result = Result.failed("修改器材信息失败！");

        try {
            WFacilityManagement wFacilityManagement = this.wEquipManageService.queryByNumber(number);

            result = Result.success(wFacilityManagement);
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }

    @PostMapping(value = "/wEquipManage/update")
    @ApiOperation(value = "器材管理-修改器材信息")
    public Result updateWequipManage(@RequestBody WequipManageAddDto wequipManageAddDto){
        System.out.println("修改器材的信息为： " + wequipManageAddDto);
        Result result = Result.failed("修改器材信息失败！");

        try {
            this.wEquipManageService.updateWequipManage(wequipManageAddDto);
            result = Result.success();
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }

    @PostMapping(value = "/wEquipManage/delete")
    @ApiOperation(value = "器材管理-删除器材信息")
    public Result deleteWequipManage(@RequestBody List<Integer> numbers){
        System.out.println("删除的器材编号集合是： " + numbers);
        Result result = Result.failed("删除器材信息失败！");

        try {
            this.wEquipManageService.deleteWequipManage(numbers);
            result = Result.success();
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }
}
