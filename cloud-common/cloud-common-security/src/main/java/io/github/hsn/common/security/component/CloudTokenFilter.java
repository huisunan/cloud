package io.github.hsn.common.security.component;

import jakarta.annotation.Resource;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import org.redisson.api.RedissonClient;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.io.IOException;

public class CloudTokenFilter implements Filter {

    @Resource
    private AuthenticationManager authenticationManager;

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        if (servletRequest instanceof HttpServletRequest httpServletRequest) {
            String token = httpServletRequest.getHeader(HttpHeaders.AUTHORIZATION);
            CloudAuthenticationToken cloudAuthenticationToken = new CloudAuthenticationToken(null);
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
