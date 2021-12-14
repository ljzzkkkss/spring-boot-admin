package com.admin.security;

import com.admin.constants.ReturnType;
import com.alibaba.fastjson.JSONObject;
import org.springframework.security.web.session.SessionInformationExpiredEvent;
import org.springframework.security.web.session.SessionInformationExpiredStrategy;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class CustomizeSessionInformationExpiredStrategy implements SessionInformationExpiredStrategy {
    @Override
    public void onExpiredSessionDetected(SessionInformationExpiredEvent sessionInformationExpiredEvent) throws IOException {
        HttpServletResponse response = sessionInformationExpiredEvent.getResponse();
        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(JSONObject.toJSONString(ReturnType.NO_SESSION));
    }
}
