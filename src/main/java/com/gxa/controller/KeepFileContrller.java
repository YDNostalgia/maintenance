package com.gxa.controller;

import com.gxa.utils.R;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@Api("维修档案接口")
public class KeepFileContrller {
    @RequestMapping("keepFile/queryAllkeepFile")
    public R queryAllRecord(){
        R r = new R();
        return r;
    }

    @RequestMapping("keepFile/addkeepFile")
    public R addRecord(){
        R r = new R();
        return r;
    }

    @RequestMapping("keepFile/updatekeepFile")
    public R updateRecord(){
        R r = new R();
        return r;
    }
    @RequestMapping("keepFile/deletekeepFile")
    public R deleteRecord(){
        R r = new R();
        return r;
    }


}
