package com.gxa.controller;

import com.gxa.dto.StatuteTypeDto;
import com.gxa.entity.Statute;
import com.gxa.entity.StatuteType;
import com.gxa.service.StatuteService;
import com.gxa.service.StatuteTypeService;
import com.gxa.utils.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Api("法规类型")
public class StatuteTypeController {

    @Autowired
    private StatuteTypeService statuteTypeService;
    @ApiOperation("查询法规")
    @GetMapping("/statuteType")
    public R list(@RequestBody StatuteTypeDto statuteTypeDto){
        R r;
        Integer limit = statuteTypeDto.getLimit();
        Integer page = statuteTypeDto.getPage();

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

}
