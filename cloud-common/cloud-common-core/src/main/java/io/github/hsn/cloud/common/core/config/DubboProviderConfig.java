package io.github.hsn.cloud.common.core.config;

import io.github.hsn.cloud.common.core.tenant.TenantProvider;
import io.github.hsn.cloud.common.core.user.UserProvider;
import org.apache.dubbo.config.annotation.DubboReference;
import org.apache.dubbo.config.spring.ReferenceBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * dubbo服务提供者配置
 */
@Configuration(proxyBeanMethods = false)
public class DubboProviderConfig {
    @Bean
    @DubboReference
    public ReferenceBean<TenantProvider> tenantProvider() {
        return new ReferenceBean<>();
    }

    @Bean
    @DubboReference
    public ReferenceBean<UserProvider> userProvider() {
        return new ReferenceBean<>();
    }
}
