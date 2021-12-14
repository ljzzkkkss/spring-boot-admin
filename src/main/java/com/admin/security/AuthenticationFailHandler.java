package com.admin.security;

import com.admin.constants.ReturnType;
import com.alibaba.fastjson.JSONObject;
import org.springframework.security.authentication.*;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class AuthenticationFailHandler extends SimpleUrlAuthenticationFailureHandler {

    @Override
    public void onAuthenticationFailure(HttpServletRequest request,
                                        HttpServletResponse response, AuthenticationException exception)
            throws IOException {
        response.setContentType("text/json;charset=utf-8");
        if (exception instanceof AccountExpiredException) {
            //账号过期
            response.getWriter().write(JSONObject.toJSONString(ReturnType.USER_ERROR));
        } else if (exception instanceof BadCredentialsException) {
            //密码错误
            response.getWriter().write(JSONObject.toJSONString(ReturnType.USER_ERROR));
        } else if (exception instanceof CredentialsExpiredException) {
            //密码过期
            response.getWriter().write(JSONObject.toJSONString(ReturnType.USER_ERROR));
        } else if (exception instanceof DisabledException) {
            //账号不可用
            response.getWriter().write(JSONObject.toJSONString(ReturnType.USER_ERROR));
        } else if (exception instanceof LockedException) {
            //账号锁定
            response.getWriter().write(JSONObject.toJSONString(ReturnType.USER_ERROR));
        } else if (exception instanceof InternalAuthenticationServiceException) {
            //用户不存在
            response.getWriter().write(JSONObject.toJSONString(ReturnType.USER_ERROR));
        }else{
            //其他错误
            response.getWriter().write(JSONObject.toJSONString(ReturnType.USER_ERROR));
        }
    }
}
