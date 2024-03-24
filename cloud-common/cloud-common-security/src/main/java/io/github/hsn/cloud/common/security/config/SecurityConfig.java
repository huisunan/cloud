package io.github.hsn.cloud.common.security.config;

import cn.hutool.core.collection.CollUtil;
import io.github.hsn.cloud.common.api.bean.common.JwtTokenInfo;
import io.github.hsn.cloud.common.api.constants.FilterOrderConstants;
import io.github.hsn.cloud.common.core.security.SecurityJwtTokenInfoProvider;
import io.github.hsn.cloud.common.core.security.SecurityUtils;
import io.github.hsn.cloud.common.security.component.*;
import jakarta.annotation.PostConstruct;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.intercept.AuthorizationFilter;
import org.springframework.security.web.authentication.AnonymousAuthenticationFilter;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import java.util.List;

@EnableWebSecurity
@Configuration
@EnableConfigurationProperties(SecurityProperties.class)
public class SecurityConfig {
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        return new CloudUsersDetailService();
    }


    @Bean
    public CloudAuthenticationEntryPoint cloudAccessDeniedHandler() {
        return new CloudAuthenticationEntryPoint();
    }

    @Bean
    public CloudJwtTokenFilter cloudJwtTokenFilter() {
        return new CloudJwtTokenFilter();
    }

    @Bean
    public CloudAuthenticationFailureHandler authenticationFailureHandler() {
        return new CloudAuthenticationFailureHandler();
    }

    @Bean
    public SecurityJwtTokenInfoProvider securityJwtTokenInfoProvider() {
        return () -> {
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            if (authentication instanceof CloudJwtAuthenticationToken cloudJwtAuthenticationToken) {
                return (JwtTokenInfo) cloudJwtAuthenticationToken.getPrincipal();
            }
            return null;
        };
    }

    @Bean
    public SecurityFilterChain securityFilterChain(
            HttpSecurity httpSecurity,
            List<CloudCustomHttpSecurity> cloudCustomHttpSecurities
    ) throws Exception {
        httpSecurity
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(auth -> auth.anyRequest()
                        .authenticated()
                )
                .addFilterBefore(cloudJwtTokenFilter(), AnonymousAuthenticationFilter.class)
                .exceptionHandling(e -> e.authenticationEntryPoint(cloudAccessDeniedHandler()));
        CollUtil.emptyIfNull(cloudCustomHttpSecurities).forEach(i -> i.accept(httpSecurity));

        return httpSecurity.build();
    }

    @PostConstruct
    public void init() {
        SecurityContextHolder.setContextHolderStrategy(new CloudSecurityContextHolderStrategy());
    }
}
