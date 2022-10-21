package com.gxa.controller;

import com.github.pagehelper.PageInfo;
import com.gxa.dto.UserDto;
import com.gxa.dto.StateDto;
import com.gxa.entity.User;
import com.gxa.service.UserService;
import com.gxa.utils.CaptchaUtil;
import com.gxa.utils.JwtUtil;
import com.gxa.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sun.plugin.dom.core.Element;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@RestController
@Api(tags = "用户管理")
public class UserController {

    @Autowired
    private UserService userService;


    private Logger logger = LoggerFactory.getLogger(UserController.class);
    /**
     * 用户登录
     */

    @GetMapping("/login")

    @ResponseBody
    public Result<String> toLogin() {
        Result<String> r=Result.failed("请登录");
        return r;
    }

    @PostMapping("/user/login")
    @ApiOperation("用户登录")
    @ResponseBody
    public Result<String> login(@RequestBody User user, HttpServletRequest request) {
        Result<String> r=new Result<>();
        System.out.println(user.getUserName());
        System.out.println(user.getPwd());
        HttpSession session= request.getSession();

//        if (user.getCaptcha());
        User user1 = this.userService.getUserByName(user.getUserName());
        System.out.println(1111);
        if (user1 == null) {
            r=Result.failed("user not exists");
            return r;
        }
        if (!user1.getPwd().equals(user.getPwd())) {
            r=Result.failed("username or password is false");
            return r;
        }
        if (user1.getState() == 0 ) {
            r=Result.failed("该用户已被禁用，请联系系统管理员");
            return r;
        }
        Map<String, Object> map = new LinkedHashMap<>();
        map.put("username", user1.getUserName());
        map.put("roleName",user1.getRoleName());
//        for (Object value : map.values()) {
//            System.out.println("value = " + value);
//        }
        String jwt = JwtUtil.createToken(map);
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(jwt, jwt);
        try {
            subject.login(usernamePasswordToken);
            logger.info("登录成功");
            r=Result.success(jwt);
            return r;
        }catch (Exception e) {
            r=Result.failed();
            return r;
        }
    }

    /**
     * 生成验证码
     */

    @GetMapping(value = "/checkCode")
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
            String captcha = (String) request.getSession().getAttribute("captcha");
            System.out.println(captcha);
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
    @PostMapping("/user/list")
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
    @PostMapping("/user/add")
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
    @PutMapping("/user/update")
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
    public Result<String> updateState(@RequestBody StateDto stateDto){
        System.out.println("***********" + stateDto.getState());
        this.userService.updateState(stateDto);
        Result<String> r=Result.success();
        return r;
    }

    @ApiOperation("修改密码")
    @PutMapping("/password/update")
    @ResponseBody
    public Result<String> updatePassword(@RequestBody User user){
        System.out.println("***********" + user.getUserName());
        this.userService.updatePassword(user);
        Result<String> r=Result.success();
        return r;
    }

    /**
     * 用户删除
     */
    @ApiOperation("用户删除")
    @DeleteMapping("/user/delete")
    @ResponseBody
    public Result<User> delete(@RequestParam("id") Integer id){
        System.out.println(id);
        this.userService.delete(id);
        this.userService.deleteRoleId(id);
        Result<User> r=Result.success();
        return r;
    }


    @GetMapping( "/unauthorized")
    public Result<String> unAuth(){
        Result<String> r=Result.failed("没有权限");
        return r;
    }




}
