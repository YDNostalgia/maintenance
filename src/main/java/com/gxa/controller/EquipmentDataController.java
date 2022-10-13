package com.gxa.controller;

import com.gxa.dto.EquipmentDataEditDto;
import com.gxa.dto.EquipmentDataQueryDto;
import com.gxa.entity.EquipmentData;
import com.gxa.service.EquipmentDataService;
import com.gxa.utils.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api("装备分类资料")
public class EquipmentDataController {
    @Autowired
    private EquipmentDataService equipmentDataService;

    @ApiOperation("查询装备分类资料")
    @GetMapping("/equipmentData")
    public R list(@RequestBody EquipmentDataQueryDto equipmentDataQueryDto){
        R r;
        Integer limit = equipmentDataQueryDto.getLimit();
        Integer page = equipmentDataQueryDto.getPage();

        List<EquipmentData> equipmentDatas = equipmentDataService.queryAll();
        if (equipmentDatas != null){
            r = R.ok();
            r.put("data",equipmentDatas);
            r.put("count",20);
            return r;
        }
        r = R.error(1,"查询失败");
        return r;
    }

    @ApiOperation("添加装备分类")
    @PostMapping("/equipmentData")
    public R add(@Param("categoryName")@ApiParam(value = "分类名称",name ="categoryName",required = true ) String categoryName){
        R r;
        r = R.error(1,"添加失败");
        r = R.ok("添加成功");
        return r;
    }


    @ApiOperation("修改装备分类")
    @PutMapping("/equipmentData")
    public R edit(@RequestBody EquipmentDataEditDto equipmentDataEditDto){
        R r;
        r = R.error(1,"修改失败");
        r = R.ok("修改成功");
        return r;
    }

    @ApiOperation("删除装备分类")
    @DeleteMapping("/equipmentData")
    public R delete(@Param("categoryId")@ApiParam(value ="分类名称",name = "categoryId",required = true) Integer categoryId ){
        R r;
        r = R.error(1,"删除失败");
        r = R.ok("删除成功");
        return r;
    }
}
