package com.gxa.shiro;

import com.gxa.utils.JwtUtil;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.web.filter.AccessControlFilter;
import org.apache.shiro.web.util.WebUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMethod;


import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MyStatelessShiroFilter extends AccessControlFilter {
    private Logger logger = LoggerFactory.getLogger(MyStatelessShiroFilter.class);
    /**
     *返回false
     * @param servletRequest
     * @param servletResponse
     * @param o
     * @return 返回结果是false的时候才会执行下面的onAccessDenied方法
     * @throws Exception
     */
    @Override
    protected boolean isAccessAllowed(ServletRequest servletRequest, ServletResponse servletResponse, Object o) throws Exception {
        logger.info("is access allowed");
        HttpServletResponse httpResponse = (HttpServletResponse) servletResponse;
        HttpServletRequest httpRequest = (HttpServletRequest) servletRequest;
        if (httpRequest.getMethod().equals(RequestMethod.OPTIONS.name())) {
            logger.info("OPTIONS放行");
            setHeader(httpRequest,httpResponse);
            return true;
        }

        return false;
    }

    /**
     * 从请求头获取token并验证，验证通过后交给realm进行登录
     * @param servletRequest
     * @param servletResponse
     * @return 返回结果为true时，表明登录认证通过，执行controller层
     * @throws Exception
     */
    @Override
    protected boolean onAccessDenied(ServletRequest servletRequest, ServletResponse servletResponse) throws Exception {
        logger.info("on access denied");
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        String jwt = request.getHeader("token");
        System.out.println(jwt);

        if (JwtUtil.verifyToken(jwt)) {
            UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(jwt, jwt);
            try {
                System.out.println("1111"+usernamePasswordToken.getUsername());
                //委托realm进行登录认证
                getSubject(servletRequest, servletResponse).login(usernamePasswordToken);
                return true;
            }catch (Exception e) {
                return false;
            }
        }
        redirectToLogin(servletRequest,servletResponse);
        return false;
    }

    /**
     * 重定向到登录页
     * @param request
     * @param response
     * @throws IOException
     */
    @Override
    protected void redirectToLogin(ServletRequest request, ServletResponse response) throws IOException {
        logger.info("redirectToLogin");
        WebUtils.issueRedirect(request, response, "/login");
    }
    private void setHeader(HttpServletRequest request, HttpServletResponse response){
        //跨域的header设置
        response.setHeader("Access-control-Allow-Origin", request.getHeader("Origin"));
        response.setHeader("Access-Control-Allow-Methods", request.getMethod());
        response.setHeader("Access-Control-Allow-Credentials", "true");
        response.setHeader("Access-Control-Allow-Headers", request.getHeader("Access-Control-Request-Headers"));
        //防止乱码，适用于传输JSON数据
        response.setHeader("Content-Type","application/json;charset=UTF-8");
        response.setStatus(HttpStatus.OK.value());
    }
}
