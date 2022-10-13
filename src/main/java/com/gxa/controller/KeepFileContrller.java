package com.gxa.controller;

import com.gxa.utils.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

@RestController
@Api("维修档案接口")
public class KeepFileContrller {
    @ApiOperation("维修档案查询")
    @GetMapping("keepFile/queryAllkeepFile")
    public R queryAllRecord(){
        R r = new R();
        return r;
    }
    @ApiOperation("维修档案添加")
    @PostMapping("keepFile/addkeepFile")
    public R addRecord(){
        R r = new R();
        return r;
    }
    @ApiOperation("维修档案修改")
    @PutMapping("keepFile/updatekeepFile")
    public R updateRecord(){
        R r = new R();
        return r;
    }
    @ApiOperation("维修档案删除")
    @DeleteMapping("keepFile/deletekeepFile")
    public R deleteRecord(){
        R r = new R();
        return r;
    }


}
