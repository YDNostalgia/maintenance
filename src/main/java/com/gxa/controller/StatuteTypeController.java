package com.gxa.controller;

import com.gxa.dto.StatuteTypeEditDto;
import com.gxa.dto.StatuteTypeQueryDto;
import com.gxa.entity.StatuteType;
import com.gxa.service.StatuteTypeService;
import com.gxa.utils.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api("法规类型")
public class StatuteTypeController {

    @Autowired
    private StatuteTypeService statuteTypeService;
    @ApiOperation("查询法规类型")
    @GetMapping("/statuteType")
    public R list(@RequestBody StatuteTypeQueryDto statuteTypeQueryDto){
        R r;
        Integer limit = statuteTypeQueryDto.getLimit();
        Integer page = statuteTypeQueryDto.getPage();

        List<StatuteType> statuteTypes = statuteTypeService.queryAll();
        if (statuteTypes != null){
            r = R.ok();
            r.put("data",statuteTypes);
            r.put("count",20);
            return r;
        }
        r = R.error(1,"查询失败");
        return r;
    }

    @ApiOperation("添加法规类型")
    @PostMapping("/statuteType")
    public R add(@Param("statuteTypeName") @ApiParam(value = "法规类型名称",name = "statuteTypeName",required = true) String statuteTypeName){
        R r;
        r = R.error(1,"添加失败");
        r = R.ok("添加成功");
        return r;
    }

    @ApiOperation("修改法规类型")
    @PutMapping("/statuteType")
    public R edit(@RequestBody StatuteTypeEditDto statuteTypeEditDto){
        R r;
        r = R.error(1,"修改失败");
        r = R.ok("修改成功");
        return r;
    }

    @ApiOperation("删除法规类型")
    @DeleteMapping("/statuteType")
    public R edit(@Param("statuteTypeId") @ApiParam(value = "法规类型名称",name = "statuteTypeId",required = true) Integer statuteTypeId){
        R r;
        r = R.error(1,"删除失败");
        r = R.ok("删除成功");
        return r;
    }

}
