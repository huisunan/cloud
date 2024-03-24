package io.github.hsn.cloud.common.security.component;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.hsn.cloud.common.api.bean.vo.R;
import io.github.hsn.cloud.common.security.util.WebUtil;
import jakarta.annotation.Resource;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.MediaType;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class CloudAuthenticationEntryPoint implements AuthenticationEntryPoint {
    @Resource
    private ObjectMapper objectMapper;


    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        WebUtil.writeR(
                objectMapper,
                response,
                HttpServletResponse.SC_UNAUTHORIZED,
                R.fail("未登录")
        );


    }
}
