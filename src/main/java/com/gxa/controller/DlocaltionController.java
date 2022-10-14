package com.gxa.controller;

import com.gxa.dto.DlocaltionEditDto;
import com.gxa.dto.DlocaltionQueryDto;
import com.gxa.entity.Dlocaltion;
import com.gxa.service.DlocaltionService;
import com.gxa.utils.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api("货位信息")
@RestController
public class DlocaltionController {

    @Autowired
    private DlocaltionService dlocaltionService;

    @ApiOperation("货位信息列表")
    @GetMapping("/dlocaltion/list")
    public R list(@RequestBody DlocaltionQueryDto dlocaltionQueryDto){
        R r;
        Integer limit = dlocaltionQueryDto.getLimit();
        Integer page = dlocaltionQueryDto.getPage();

        List<Dlocaltion> dlocaltions = this.dlocaltionService.selectList();
        if (dlocaltions != null){
            r = R.ok();
            r.put("data",dlocaltions);
            r.put("count",20);
            return r;
        }
        r = R.error(1,"查询失败");
        return r;
    }

    @ApiOperation("添加货位信息")
    @PostMapping("/dlocaltion/add")
    public R add(@Param("name")@ApiParam(value = "区域名称",name ="name",required = true ) String name){
        R r;
        r = R.error(1,"添加失败");
        r = R.ok("添加成功");
        return r;
    }


    @ApiOperation("修改货位信息")
    @PutMapping("/dlocaltion/edit")
    public R edit(@RequestBody DlocaltionEditDto dlocaltionEditDto){
        R r;
        r = R.error(1,"修改失败");
        r = R.ok("修改成功");
        return r;
    }

    @ApiOperation("删除货位信息")
    @DeleteMapping("/dlocaltion/delete")
    public R delete(@Param("id")@ApiParam(value ="区域名称",name = "id",required = true) Integer id ){
        R r;
        r = R.error(1,"删除失败");
        r = R.ok("删除成功");
        return r;
    }
}
