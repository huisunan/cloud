package io.github.hsn.cloud.sys.base.security;

import io.github.hsn.cloud.common.security.component.CloudCustomHttpSecurity;
import io.github.hsn.cloud.common.security.point.CloudJwtTokenFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;

@Configuration
public class CloudCustomHttpSecurityConfig {

    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider(
            PasswordEncoder passwordEncoder,
            UserDetailsService userDetailsService
    ) {
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider(passwordEncoder);
        daoAuthenticationProvider.setUserDetailsService(userDetailsService);
        return daoAuthenticationProvider;
    }

    @Bean
    public AuthenticationManager authenticationManager(List<AuthenticationProvider> authenticationProviders) {
        return new ProviderManager(authenticationProviders);
    }
    @Bean
    public CloudAuthenticationSuccessHandler cloudAuthenticationSuccessHandler() {
        return new CloudAuthenticationSuccessHandler();
    }

    @Bean
    public CompositeLoginFilter compositeLoginFilter() {
        CompositeLoginFilter compositeLoginFilter = new CompositeLoginFilter();
        compositeLoginFilter.setAuthenticationSuccessHandler(cloudAuthenticationSuccessHandler());
        return compositeLoginFilter;
    }

    @Bean
    public CloudCustomHttpSecurity upmsCloudCustomHttpSecurity() {
        return httpSecurity -> {
            httpSecurity.addFilterBefore(compositeLoginFilter(), CloudJwtTokenFilter.class);

        };
    }
}
