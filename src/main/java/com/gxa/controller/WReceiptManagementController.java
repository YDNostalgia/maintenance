package com.gxa.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.gxa.dto.WReceiptManagementDto;
import com.gxa.dto.WReceiptManagementFacilityDto;
import com.gxa.dto.WReceiptManagementStatusDto;
import com.gxa.entity.WReceiptManagement;
import com.gxa.service.WReceiptManagementService;
import com.gxa.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(tags = "入库管理")
@RestController
public class WReceiptManagementController {

    @Autowired
    private WReceiptManagementService wReceiptManagementService;

    @ApiOperation(value = "审核状态 下拉列表(1.待审核，2.审核通过，3.审核拒绝)")
    @PostMapping(value = "/wReceiptManagement/status")
    public Result<List<WReceiptManagementStatusDto>> selectByStatus(){
        Result<List<WReceiptManagementStatusDto>> listResult = Result.failed("审核状态获取失败");

        try{
            List<WReceiptManagementStatusDto> wReceiptManagementStatusDtos = this.wReceiptManagementService.queryByStatus();
            System.out.println("查询记录数————>" + wReceiptManagementStatusDtos);

            Integer size = wReceiptManagementStatusDtos.size();
            Long total = size.longValue();
            System.out.println("total——————>" + total);

            listResult = Result.success(wReceiptManagementStatusDtos,total);
            return listResult;
        } catch (Exception e){
            e.printStackTrace();
        }
        return listResult;
    }


    @ApiOperation(value = "入库信息列表 条件查询")
    @PostMapping(value = "/wReceiptManagement/list")
    public Result<List<WReceiptManagement>> selectList(@RequestBody(required = false) WReceiptManagementDto wReceiptManagementDto){
        System.out.println("查询条件—————>" + wReceiptManagementDto);
        System.out.println("当前页码：" + wReceiptManagementDto.getPage() + ",每页记录数：" + wReceiptManagementDto.getLimit());

        Result<List<WReceiptManagement>> listResult = Result.failed("入库信息查询失败！");

        try{
            List<WReceiptManagement> wReceiptManagements = this.wReceiptManagementService.queryChoiceAll(wReceiptManagementDto);
            System.out.println("查询记录数————>" + wReceiptManagements);

            //实现分页
            PageHelper.startPage(wReceiptManagementDto.getPage(),wReceiptManagementDto.getLimit());

            PageInfo<WReceiptManagement> pageInfo = new PageInfo<>(wReceiptManagements);
            Long total = pageInfo.getTotal();
            System.out.println("total————>" + total);

            listResult = Result.success(wReceiptManagements,total);
            return listResult;
        } catch (Exception e){
            e.printStackTrace();
        }
        return listResult;
    }


    @ApiOperation(value = "器材名称 下拉查询")
    @PostMapping(value = "/wReceiptManagement/facilityName")
    public Result<List<WReceiptManagementFacilityDto>> selectByFacilityName(){
        Result<List<WReceiptManagementFacilityDto>> listResult = Result.failed("器材名称获取失败");

        try{
            List<WReceiptManagementFacilityDto> wReceiptManagementFacilityDtos = this.wReceiptManagementService.queryFacilityName();
            System.out.println("查询记录数————>" + wReceiptManagementFacilityDtos);

            Integer size = wReceiptManagementFacilityDtos.size();
            Long total = size.longValue();
            System.out.println("total——————>" + total);

            listResult=Result.success(wReceiptManagementFacilityDtos,total);
            return listResult;
        }catch (Exception e){
            e.printStackTrace();
        }
        return listResult;
    }

    @ApiOperation(value = "器材型号 下拉查询")
    @PostMapping(value = "/wReceiptManagement/facilityModel")
    public Result<List<WReceiptManagementFacilityDto>> selectFacilityModel(String name){
        Result<List<WReceiptManagementFacilityDto>> listResult = Result.failed("器材型号获取失败");

        try{
            List<WReceiptManagementFacilityDto> wReceiptManagementFacilityDtos = this.wReceiptManagementService.queryFacilityModel(name);
            System.out.println("查询记录数——————>" + wReceiptManagementFacilityDtos);

            Integer size = wReceiptManagementFacilityDtos.size();
            Long total = size.longValue();
            System.out.println("total——————>" + total);

            listResult = Result.success(wReceiptManagementFacilityDtos,total);
            return listResult;
        } catch (Exception e){
            e.printStackTrace();
        }
        return listResult;
    }

    @ApiOperation(value = "获取 器材编号")
    @PostMapping("/wReceiptManagement/FacilityNumber")
    public Result<List<WReceiptManagementFacilityDto>> selectNumber(@RequestBody(required = false) WReceiptManagementFacilityDto wReceiptManagementFacilityDto){
        Result<List<WReceiptManagementFacilityDto>> listResult = Result.failed("器材编号获取失败");

        try{
            List<WReceiptManagementFacilityDto> wReceiptManagementFacilityDtos = this.wReceiptManagementService.queryFacilityNumber(wReceiptManagementFacilityDto);
            System.out.println("查询记录数——————>" + wReceiptManagementFacilityDtos);

            Integer size = wReceiptManagementFacilityDtos.size();
            Long total = size.longValue();
            System.out.println("total————————>" + total);

            listResult = Result.success(wReceiptManagementFacilityDtos,total);
            return listResult;
        }catch (Exception e){
            e.printStackTrace();
        }
        return listResult;
    }

}
