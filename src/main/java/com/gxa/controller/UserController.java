package com.gxa.controller;

import com.github.pagehelper.PageInfo;
import com.gxa.dto.UserDto;
import com.gxa.dto.StateDto;
import com.gxa.entity.User;
import com.gxa.service.UserService;
import com.gxa.utils.CaptchaUtil;
import com.gxa.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import static com.gxa.utils.CaptchaUtil.RANDOMCODEKEY;

@RestController
@Api(tags = "用户管理")
public class UserController {

    @Autowired
    private UserService userService;


    @PostMapping("/user/login")
    @ApiOperation("用户登录")
    @ResponseBody
    /**
     * 用户登录
     */
    public String login(@RequestBody User user, HttpSession session){
        System.out.println(user);
        System.out.println(session.getAttribute(user.getCaptcha())+"sddddd"+session.getAttribute(RANDOMCODEKEY));

//        Subject subject = SecurityUtils.getSubject();
//        UsernamePasswordToken token = new UsernamePasswordToken(user.getUserName(),user.getPwd());

        try{
            User user1 = this.userService.login(user.getUserName(),user.getPwd());
            if (user1!=null){
                System.out.println("成功");
            }
//            subject.login(token);
            //登录成功

            return "redirect:/main.html";
        }catch (Exception e){
            e.printStackTrace();
            //登录失败
            return "redirect:/index.html";
        }
    }

    /**
     * 生成验证码
     */

    @RequestMapping(value = "/checkCode")
    public void checkCode(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //设置相应类型,告诉浏览器输出的内容为图片
        response.setContentType("image/jpeg");
        //设置响应头信息，告诉浏览器不要缓存此内容
        response.setHeader("pragma", "no-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expire", 0);

        CaptchaUtil captchaUtil = new CaptchaUtil();
        try {
            captchaUtil.getRandcode(request, response);//输出图片方法
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    /**
     * 用户退出
     */

    @ApiOperation("用户退出")
    @GetMapping("/user/logout")
    @ResponseBody
    public String logout(HttpSession session){
        session.invalidate();

        return "redirect:/index.html";

    }


    /**
     * 用户列表
     */
    @ApiOperation("用户列表")
    @GetMapping("/user")
    @ResponseBody
    public Result<List<User>> list(@RequestBody(required = false) UserDto userDto, Integer page, Integer limit){

        PageInfo pageInfo = this.userService.queryAll(userDto,page,limit);

        Result<List<User>> r=Result.success(pageInfo.getList(),pageInfo.getTotal());
        return r;
    }

    /**
     * 用户添加
     */
    @ApiOperation("用户添加")
    @PostMapping("/user")
    @ResponseBody
    public Result<User> add(@RequestBody User user){
        System.out.println("***********" + user);
        user.setAddTime(new Date());
        user.setState(1);
        this.userService.add(user);
        Integer roleId =this.userService.queryRoleId(user.getRoleName());
        System.out.println(user.getId());
        this.userService.addUserRoleId(user.getId(), roleId);
        Result<User> r=Result.success();
        return r;
    }


    @ApiOperation("查询角色")
    @PostMapping("/user/roleName")
    @ResponseBody
    public Result<List<String>> queryRoleName(){
        List<String> roleName=this.userService.queryRoleName();
        Result<List<String>> r=Result.success(roleName);
        return r;
    }


    /**
     * 用户修改
     */
    @ApiOperation("用户修改")
    @PutMapping("/user")
    @ResponseBody
    public Result<User> update(@RequestBody User user){
        System.out.println("***********" + user);
        this.userService.update(user);
        Result<User> r=Result.success();
        return r;
    }

    @ApiOperation("修改状态")
    @PutMapping("/user/state")
    @ResponseBody
    public Result<StateDto> updateState(@RequestBody StateDto stateDto){
        System.out.println("***********" + stateDto.getState());
        this.userService.updateState(stateDto);
        Result<StateDto> r=Result.success();
        return r;
    }

    /**
     * 用户删除
     */
    @ApiOperation("用户删除")
    @DeleteMapping("/user")
    @ResponseBody
    public Result<User> delete(@RequestParam("id") Integer id){
        System.out.println(id);
        this.userService.delete(id);
        Result<User> r=Result.success();
        return r;
    }




}
