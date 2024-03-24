package io.github.hsn.cloud.upms.base.security;

import cn.hutool.core.util.ArrayUtil;
import cn.hutool.core.util.StrUtil;
import jakarta.annotation.Resource;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class CompositeLoginFilter extends AbstractAuthenticationProcessingFilter {

    private final String FORM_GRANT_TYPE_KEY = "grant_type";

    protected CompositeLoginFilter() {
        super("/login");

    }


    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException, IOException, ServletException {
        Map<String, String> paramMap = convertParam(request);
        String grantType = paramMap.get(FORM_GRANT_TYPE_KEY);
        if (StrUtil.isBlank(grantType)) {
            throw new GrantTypeException("登录类型不能为空");
        }
        Authentication authentication = null;
        if (grantType.equals("password")) {
            authentication = UsernamePasswordAuthenticationToken.unauthenticated(
                    paramMap.get("username"),
                    paramMap.get("password")
            );
        }
        return getAuthenticationManager().authenticate(authentication);
    }

    private Map<String, String> convertParam(HttpServletRequest request) {
        return request.getParameterMap()
                .entrySet()
                .stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        entry -> ArrayUtil.get(entry.getValue(), 0)
                ));
    }


    @Override
    @Resource
    public void setAuthenticationManager(AuthenticationManager authenticationManager) {
        super.setAuthenticationManager(authenticationManager);
    }

}
