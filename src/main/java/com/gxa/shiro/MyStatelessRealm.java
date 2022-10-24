package com.gxa.shiro;

import com.gxa.mapper.UserMapper;
import com.gxa.utils.JwtUtil;

import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;


import java.util.Set;

public class MyStatelessRealm extends AuthorizingRealm {

    @Autowired
    private UserMapper userMapper;
    Logger logger = LoggerFactory.getLogger(MyStatelessRealm.class);

    public boolean supports(AuthenticationToken token) {
        return token instanceof UsernamePasswordToken;
    }
    /**
     * Realm授权
     * @param principals
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        System.out.println("--------------------授权------------------------");
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        logger.info("授权开始");
        String jwt = (String) principals.getPrimaryPrincipal();
        if (JwtUtil.verifyToken(jwt)) {
//            String role = (String) JwtUtil.parseToken(jwt).get("role");
//            System.out.println(role+"11111");

            String roleName = (String) JwtUtil.parseToken(jwt).get("roleName");
            Set<String> perms = userMapper.queryPermsByUserName(roleName);

            authorizationInfo.addStringPermissions(perms);
//            authorizationInfo.addRole(role);
            logger.info("授权成功");
            return authorizationInfo; 
        }
        logger.info("授权失败");
        return null;
    }

    /**
     * Realm登录认证
     * @param token
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        System.out.println("--------------------认证------------------------");
        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) token;
        String jwt = (String) usernamePasswordToken.getPrincipal();
        if (JwtUtil.verifyToken(jwt)) {
            return new SimpleAuthenticationInfo(jwt, jwt ,getName());
        }
        return null;
    }
}
