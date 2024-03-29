package com.admin.security;

import com.admin.constants.ReturnType;
import com.alibaba.fastjson.JSONObject;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class AuthenticationSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request,
                                        HttpServletResponse response, Authentication authentication)
            throws IOException {
        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(JSONObject.toJSONString(ReturnType.SUCCESS));
    }
}
