package com.gxa.controller;

import com.gxa.dto.TDataAddDto;
import com.gxa.dto.TDataEditDto;
import com.gxa.dto.TDataQueryDto;
import com.gxa.entity.TData;
import com.gxa.service.TDataService;
import com.gxa.utils.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController //等同于@Controller（表面这个类是一个控制器类）+@ResponseBody（方法的返回值以指定格式写入http response body中）
@Api("资料")
public class TDataController {

    @Autowired
    private TDataService tDataService;

    @ApiOperation("查询资料")
    @GetMapping("/data/list")   //将 HTTP 的get 请求映射到特定处理程序的方法注解。
    public R list(@RequestBody TDataQueryDto tDataQueryDto){  //@RequestBody接收前端传递给后端的json字符串中的数据的(请求体中的数据的)
        R r;
        Integer limit = tDataQueryDto.getLimit();
        Integer page = tDataQueryDto.getPage();
        List<TData> tData = this.tDataService.queryAllDatas();

        if (tData != null){
            r = R.ok();
            r.put("data", tData);
            r.put("count",20);
            return r;
        }

        r = R.error(1,"查询失败");
        return r;
    }

    @ApiOperation("添加资料")
    @PostMapping("/data/add")
    public R add(@RequestBody TDataAddDto tDataAddDto){
        R r;
        r = R.error(1,"添加失败");
        r = R.ok("添加成功");
        return r;
    }

    @ApiOperation("修改资料")
    @PutMapping("/data/edit")
    public R edit(TDataEditDto tDataEditDto){
        R r;
        r = R.error(1,"修改失败");
        r = R.ok("修改成功");
        return r;
    }



}
