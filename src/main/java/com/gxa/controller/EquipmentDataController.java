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
    public Result add(@RequestBody EquipmentDataToAdd equipmentDataToAdd){
        System.out.println(equipmentDataToAdd.getCategoryId());
        System.out.println(equipmentDataToAdd.getCategoryName());
        if (equipmentDataToAdd != null){
            this.equipmentDataService.add(equipmentDataToAdd);
            return Result.success();
        }else {
            return Result.failed();
        }



    }


    @ApiOperation("修改资料分类")
    @PutMapping("/equipmentData/edit")
    public Result update(@RequestBody EquipmentDataToEdit equipmentDataToEdit){
        if (equipmentDataToEdit != null){
            this.equipmentDataService.update(equipmentDataToEdit);
            return Result.success();
        }else {
            return Result.failed();
        }

    }

    @ApiOperation("删除资料分类")
    @DeleteMapping("/equipmentData/delete")
    public R delete(@Param("categoryId")@ApiParam(value ="资料类型id",name = "categoryId",required = true) Integer categoryId ){
        R r;
        this.equipmentDataService.delete(categoryId);
        r = R.ok("删除成功");
        return r;
        }

    }

