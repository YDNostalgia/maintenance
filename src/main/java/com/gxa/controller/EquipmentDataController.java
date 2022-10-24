package com.gxa.controller;

import com.github.pagehelper.PageInfo;
import com.gxa.entity.EquipmentData;
import com.gxa.entity.EquipmentDataToAdd;
import com.gxa.entity.EquipmentDataToEdit;
import com.gxa.service.EquipmentDataService;
import com.gxa.utils.R;
import com.gxa.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(tags = "资料类型接口")
public class EquipmentDataController {

    @Autowired
    private EquipmentDataService equipmentDataService;
    private Result<Integer> integerResult;

    @ApiOperation("查询资料分类")
    @GetMapping("/equipmentData/list")
    public Result<List<EquipmentData>> queryAllEquipmentData(Integer page,Integer limit){
        System.out.println(page+"------"+limit);
        Result<List<EquipmentData>> r = Result.success();
        try {
            PageInfo<EquipmentData> pageInfo = equipmentDataService.queryAll(page, limit);
            r = Result.success(pageInfo.getList(),pageInfo.getTotal());
        }catch (Exception e){
            e.printStackTrace();
            Result.failed();
        }
        return r;
    }

    @ApiOperation("添加资料分类")
    @PostMapping("/equipmentData/add")
    public Result<List<EquipmentDataToAdd>> add(@RequestBody(required = false) EquipmentDataToAdd equipmentDataToAdd){
        Result<List<EquipmentDataToAdd>> r = Result.success();
        try {
            System.out.println("equipmentDataToAdd------"+equipmentDataToAdd);
            equipmentDataService.add(equipmentDataToAdd);
        }catch (Exception e){
            e.printStackTrace();
            Result.success();
        }
        return  r;
    }


    @ApiOperation("修改资料分类")
    @PutMapping("/equipmentData/update")
    public Result<List<EquipmentDataToEdit>> update(@RequestBody(required = false) EquipmentDataToEdit equipmentDataToEdit){
        System.out.println("equipmentDataToEdit------"+equipmentDataToEdit);
        Result<List<EquipmentDataToEdit>> r = Result.success();
        try {
            equipmentDataService.update(equipmentDataToEdit);
        }catch (Exception e){
            e.printStackTrace();
            Result.failed();
        }
        return r;
    }

    @ApiOperation("删除资料分类")
    @DeleteMapping("/equipmentData/delete")
    @ResponseBody
    public Result<Integer> delete( @RequestParam("categoryId") Integer categoryId ){

        Integer dataCount = equipmentDataService.getDataCountInteger(categoryId);
        Result<Integer> r = new Result<>();


        if (dataCount == 0){

            try {
                equipmentDataService.delete(categoryId);
                r = Result.success();
            }catch (Exception e){
                e.printStackTrace();
               r =  Result.failed();
            }
        }else {
           r =  Result.failed("删除失败，不能删除资料数不为0的资料分类");
        }
        return r;
    }
}


