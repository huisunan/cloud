package io.github.hsn.common.security.config;

import io.github.hsn.common.security.component.CloudAuthenticationEntryPoint;
import io.github.hsn.common.security.component.CloudSecurityContextHolderStrategy;
import io.github.hsn.common.security.component.CloudUsersDetailService;
import jakarta.annotation.PostConstruct;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@Configuration
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
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(auth -> auth.anyRequest()
                        .authenticated()
                )
                .exceptionHandling(e -> e.authenticationEntryPoint(cloudAccessDeniedHandler()))
                .build();
    }

    @PostConstruct
    public void init() {
        SecurityContextHolder.setContextHolderStrategy(new CloudSecurityContextHolderStrategy());
    }
}
