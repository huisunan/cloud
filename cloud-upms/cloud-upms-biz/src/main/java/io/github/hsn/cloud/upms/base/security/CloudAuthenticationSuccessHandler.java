package io.github.hsn.cloud.upms.base.security;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.date.DateField;
import cn.hutool.core.date.DateUtil;
import cn.hutool.jwt.JWT;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.hsn.cloud.common.api.bean.common.JwtTokenInfo;
import io.github.hsn.cloud.common.api.bean.vo.R;
import io.github.hsn.cloud.common.security.detail.CloudUserBaseDetailsImpl;
import io.github.hsn.cloud.common.security.config.SecurityProperties;
import jakarta.annotation.Resource;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Date;

public class CloudAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    @Resource
    private ObjectMapper objectMapper;

    @Resource
    private SecurityProperties securityProperties;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        /*
         * 生成一个token
         */
        CloudUserBaseDetailsImpl cloudUserDetailsImpl = (CloudUserBaseDetailsImpl) authentication.getPrincipal();
        JwtTokenInfo jwtTokenInfo = new JwtTokenInfo(cloudUserDetailsImpl.getId(), cloudUserDetailsImpl.getUsername());
        String token = JWT.create()
                .addPayloads(BeanUtil.beanToMap(jwtTokenInfo))
                .setExpiresAt(DateUtil.offset(new Date(), DateField.MINUTE, 10))
                .setKey(securityProperties.getJwtKey().getBytes())
                .sign();


        response.setCharacterEncoding(StandardCharsets.UTF_8.name());
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        response.getWriter().write(objectMapper.writeValueAsString(R.success(token)));
    }


}
