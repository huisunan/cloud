package io.github.hsn.cloud.common.security.point;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.jwt.JWT;
import cn.hutool.jwt.JWTUtil;
import io.github.hsn.cloud.common.api.bean.common.JwtTokenInfo;
import io.github.hsn.cloud.common.security.authentication.CloudJwtAuthenticationToken;
import io.github.hsn.cloud.common.security.config.SecurityProperties;
import io.github.hsn.cloud.common.security.detail.CloudUserBaseDetails;
import io.github.hsn.cloud.common.security.exceptions.JwtTokenException;
import jakarta.annotation.Resource;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import java.io.IOException;

public class CloudJwtTokenFilter implements Filter {

    @Resource
    private SecurityProperties securityProperties;

    @Resource
    private AuthenticationFailureHandler authenticationFailureHandler;


    @Resource
    private UserDetailsService userDetailsService;

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (
                servletRequest instanceof HttpServletRequest httpServletRequest
                        && servletResponse instanceof HttpServletResponse httpServletResponse
                        && httpServletRequest.getHeader(HttpHeaders.AUTHORIZATION) != null
                        && authentication == null
        ) {
            try {
                String token = httpServletRequest.getHeader(HttpHeaders.AUTHORIZATION);
                boolean verify = JWTUtil.verify(token, securityProperties.getJwtKey().getBytes());
                if (!verify) {
                    throw new JwtTokenException("登录信息失效");
                }
                JWT jwt = JWTUtil.parseToken(token);
                JwtTokenInfo jwtTokenInfo = BeanUtil.copyProperties(jwt.getPayload().getClaimsJson(), JwtTokenInfo.class);

                CloudJwtAuthenticationToken cloudJwtAuthenticationToken = new CloudJwtAuthenticationToken(
                        token,
                        (CloudUserBaseDetails) userDetailsService.loadUserByUsername(jwtTokenInfo.getUsername())
                );
                cloudJwtAuthenticationToken.setAuthenticated(true);

                SecurityContextHolder.getContext().setAuthentication(cloudJwtAuthenticationToken);
            } catch (Exception e) {
                AuthenticationException exception = e instanceof AuthenticationException authenticationException
                        ? authenticationException
                        : new InternalAuthenticationServiceException(e.getMessage(), e.getCause());
                authenticationFailureHandler.onAuthenticationFailure(
                        httpServletRequest,
                        httpServletResponse,
                        exception
                );
            }

        }
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
