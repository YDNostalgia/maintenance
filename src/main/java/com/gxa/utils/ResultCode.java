package com.gxa.utils;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
public enum ResultCode implements IResultCode, Serializable {

    SUCCESS("0", "一切ok"),

    USER_ERROR("1", "用户端错误"),

    TOKEN_INVALID_OR_EXPIRED("A0230", "token无效或已过期"),
    TOKEN_ACCESS_FORBIDDEN("A0231", "token已被禁止访问"),
    TOKEN_ACCESS_PERMISSION("A0232", "用户没有对应的权限"),

    AUTHORIZED_ERROR("A0300", "访问权限异常"),
    ACCESS_UNAUTHORIZED("A0301", "访问未授权"),
    FORBIDDEN_OPERATION("A0302", "演示环境禁止修改、删除重要数据，请本地部署后测试"),


    PARAM_ERROR("A0400", "用户请求参数错误"),
    RESOURCE_NOT_FOUND("A0401", "请求资源不存在"),
    PARAM_IS_NULL("A0410", "请求必填参数为空"),


    SYSTEM_EXECUTION_ERROR("B0001", "系统执行出错"),
    SYSTEM_EXECUTION_TIMEOUT("B0100", "系统执行超时"),
    ;

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public String getMsg() {
        return msg;
    }

    private String code;

    private String msg;

    @Override
    public String toString() {
        return "{" +
                "\"code\":\"" + code + '\"' +
                ", \"msg\":\"" + msg + '\"' +
                '}';
    }


    public static ResultCode getValue(String code){
        for (ResultCode value : values()) {
            if (value.getCode().equals(code)) {
                return value;
            }
        }
        return SYSTEM_EXECUTION_ERROR; // 默认系统执行错误
    }
}
