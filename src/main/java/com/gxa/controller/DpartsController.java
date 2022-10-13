package com.gxa.controller;

import com.gxa.dto.DpartsEditDto;
import com.gxa.dto.DpartsQueryDto;
import com.gxa.entity.Dparts;
import com.gxa.service.DpartsService;
import com.gxa.utils.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(value = "器材分类")
@RestController
public class DpartsController {

    @Autowired
    private DpartsService dpartsService;

    @ApiOperation("器材分类列表")
    @GetMapping("/dparts/list")
    public R list(@RequestBody DpartsQueryDto dpartsQueryDto){
        R r;
        Integer limit = dpartsQueryDto.getLimit();
        Integer page = dpartsQueryDto.getPage();

        List<Dparts> dparts = this.dpartsService.queryList();
        if (dparts != null){
            r = R.ok();
            r.put("data",dparts);
            r.put("count",20);
            return r;
        }
        r = R.error(1,"查询失败");
        return r;
    }

    @ApiOperation("器材分类信息")
    @PostMapping("/dparts/add")
    public R add(@Param("name")@ApiParam(value = "区域名称",name ="name",required = true ) String name){
        R r;
        r = R.error(1,"添加失败");
        r = R.ok("添加成功");
        return r;
    }


    @ApiOperation("器材分类位信息")
    @PutMapping("/dparts/edit")
    public R edit(@RequestBody DpartsEditDto dpartsEditDto){
        R r;
        r = R.error(1,"修改失败");
        r = R.ok("修改成功");
        return r;
    }

    @ApiOperation("器材分类信息")
    @DeleteMapping("/dparts/delete")
    public R delete(@Param("id")@ApiParam(value ="区域名称",name = "id",required = true) Integer id ){
        R r;
        r = R.error(1,"删除失败");
        r = R.ok("删除成功");
        return r;
    }
}
