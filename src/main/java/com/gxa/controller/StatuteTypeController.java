package com.gxa.controller;

import com.github.pagehelper.PageInfo;
import com.gxa.dto.StatuteTypeEditDto;
import com.gxa.dto.StatuteTypeQueryDto;
import com.gxa.entity.StatuteType;
import com.gxa.service.StatuteTypeService;
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
@Api(tags = "法规类型")
public class StatuteTypeController {

    @Autowired
    private StatuteTypeService statuteTypeService;
    @ApiOperation("查询法规类型")
    @PostMapping("/statuteType/list")
    public Result<List<StatuteType>> list(@RequestBody StatuteTypeQueryDto statuteTypeQueryDto){

        Result<List<StatuteType>> r = Result.failed();
        PageInfo<StatuteType> pageInfo = statuteTypeService.queryAll(statuteTypeQueryDto);
        List<StatuteType> statuteTypes = pageInfo.getList();
        long total = pageInfo.getTotal();

        if (statuteTypes != null){
            r = Result.success(statuteTypes,total);
            return r;
        }
        return r;
    }

    @ApiOperation("添加法规类型")
    @PostMapping("/statuteType")
    public Result add(@RequestBody @ApiParam(value = "法规类型名称",name = "statuteTypeName",required = true) String statuteTypeName){

        Result r = Result.failed();

        try {
            statuteTypeService.add(statuteTypeName);
            r = Result.success();
            return r;
        }catch (Exception e){
            e.printStackTrace();
        }
        return r;
    }

    @ApiOperation("修改法规类型")
    @PutMapping("/statuteType")
    public Result edit(@RequestBody StatuteTypeEditDto statuteTypeEditDto){
        Result r = Result.failed("修改失败");
        try {
            statuteTypeService.update(statuteTypeEditDto);
            r = Result.success();
            return r;
        }catch (Exception e){
            e.printStackTrace();
        }
        return r;
    }

    @ApiOperation("删除法规类型")
    @DeleteMapping("/statuteType")
    public Result delete(@RequestBody @ApiParam(value = "法规类型名称",name = "statuteTypeId",required = true) Integer statuteTypeId){
        Result r = Result.failed("删除失败");
        try {
            statuteTypeService.delete(statuteTypeId);
            r = Result.success();
            return r;
        }catch (Exception e){
            e.printStackTrace();
        }
        return r;
    }

}
