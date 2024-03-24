package io.github.hsn.cloud.common.security.component;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.hsn.cloud.common.api.bean.vo.R;
import io.github.hsn.cloud.common.security.util.WebUtil;
import jakarta.annotation.Resource;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import java.io.IOException;

public class CloudAuthenticationFailureHandler implements AuthenticationFailureHandler {
    @Resource
    private ObjectMapper objectMapper;

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        String message = null;
        if (exception instanceof JwtTokenException jwtTokenException) {
            message = jwtTokenException.getMessage();
        } else {
            message = "登录失败";
        }

        WebUtil.writeR(
                objectMapper,
                response,
                HttpServletResponse.SC_UNAUTHORIZED,
                R.fail(message)
        );
    }
}
