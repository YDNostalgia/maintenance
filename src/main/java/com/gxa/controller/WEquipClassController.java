package com.gxa.controller;

import com.gxa.dto.WFacilityClass2AddDto;
import com.gxa.dto.WFacilityClass2UpdateDto;
import com.gxa.entity.WEquipClass;
import com.gxa.entity.WFacilityClass1;
import com.gxa.entity.WFacilityClass2;
import com.gxa.service.WEquipClassService;
import com.gxa.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Api(tags = "W-器材分类接口")
public class WEquipClassController {

    @Autowired
    private WEquipClassService wEquipClassService;

    @GetMapping(value = "/dparts/list")
    @ApiOperation(value = "器材分类-器材分类信息列表")
    public Result<List<WEquipClass>> wEquipClassList(){
        Result<List<WEquipClass>> result = Result.failed("器材分类信息拉取失败！");

//        try {
            List<WEquipClass> wEquipClasses = this.wEquipClassService.queryAllWEquipClass();
            Integer size = wEquipClasses.size();
            Long total = size.longValue();
            result = Result.success(wEquipClasses,total);
//        }catch (Exception e){
//            e.printStackTrace();
//        }

        return result;
    }

    @PostMapping(value = "/dparts/addClass1")
    @ApiOperation(value = "器材分类-添加一级器材种类")
    public Result addWfacilityClass1(String wFacilityClass1Name){
        System.out.println("添加一级器材种类的名称为：" + wFacilityClass1Name);
        Result result = Result.failed("添加一级器材种类失败");

        try {
            this.wEquipClassService.addWfacilityClass1(wFacilityClass1Name);
            result = Result.success();
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }


    @PostMapping(value = "/dparts/addClass2")
    @ApiOperation(value = "器材分类-添加二级器材种类")
    public Result addWfacilityClass2(@RequestBody WFacilityClass2AddDto wFacilityClass2AddDto){
        System.out.println("添加的二级器材种类信息为： " + wFacilityClass2AddDto);
        Result result = Result.failed("添加二级器材种类失败！");

        try {
            this.wEquipClassService.addWfacilityClass2(wFacilityClass2AddDto);
            result = Result.success();
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }

    @PostMapping(value = "/dparts/updateClass1Name")
    @ApiOperation(value = "器材分类-修改一级器材种类名称")
    public Result updateWfacilityClass1Name(@RequestBody WFacilityClass1 wFacilityClass1){
        System.out.println("修改一级类别器材名称为： " + wFacilityClass1);
        Result result = Result.failed("修改一级类别器材名称失败！");

        try {
            this.wEquipClassService.updateWfacilityClass1Name(wFacilityClass1);
            result = Result.success();
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }

    @PostMapping(value = "/dparts/updateClass2Name")
    @ApiOperation(value = "器材分类-修改二级器材种类名称")
    public Result updateWfacilityClass2Name(@RequestBody WFacilityClass2UpdateDto wFacilityClass2UpdateDto){
        System.out.println("修改二级类别器材名称为: " + wFacilityClass2UpdateDto);
        Result result = Result.failed("修改二级器材种类名称失败！");

        try {
            this.wEquipClassService.updateWfacilityClass2Name(wFacilityClass2UpdateDto);
            result = Result.success();
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }

    @GetMapping(value = "/dparts/deleteClass1")
    @ApiOperation(value = "器材分类-删除一级器材种类")
    public Result deleteWfacilityClass1(Integer id){
        System.out.println("需要删除一级种类的器材编号是：" + id);
        Result result = Result.failed();


        try {
            Integer count = 0;
            List<WEquipClass> wEquipClasses = this.wEquipClassService.queryAllWEquipClass();
            for(int i = 0;i < wEquipClasses.size();i++){
                WEquipClass wEquipClass = wEquipClasses.get(i);
                if(wEquipClass.getId() ==  id){
                    count = wEquipClass.getCount();
                }
            }

            if(count > 0){
                result = Result.failed("该级别器材种类中还有器材，不能删除！");
            } else if(count == 0){
                this.wEquipClassService.deleteWfacilityClass1(id);
                result = Result.success();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }

    @GetMapping(value = "/dparts/deleteClass2")
    @ApiOperation(value = "器材分类-删除二级器材种类")
    public Result deleteWfacilityClass2(int id){
        System.out.println("需要删除二级种类的器材编号是：" + id);
        Result result = Result.failed();

        try {
            List<WFacilityClass2> wFacilityClass2s = this.wEquipClassService.queryALLWfacilityClass2Quantity();
            System.out.println("二级器材和数量的对应关系是： " + wFacilityClass2s);

            for(int i = 0;i < wFacilityClass2s.size();i++){
                WFacilityClass2 wFacilityClass2 = wFacilityClass2s.get(i);
                int class2Id = wFacilityClass2.getId();
                int count = wFacilityClass2.getCount();


                if(id == class2Id && count > 0){
                    result = Result.failed("该级别器材种类中还有器材，不能删除！");
                }else if(id == class2Id && count == 0){
                    this.wEquipClassService.deleteWfacilityClass2(id);
                    result = Result.success();
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }
}
