package io.github.hsn.common.core.config;

import io.github.hsn.common.core.redisson.CloudMsgPackJacksonCodec;
import org.redisson.spring.starter.RedissonAutoConfigurationCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration(proxyBeanMethods = false)
public class RedissonConfig {

    /**
     * 配置编解码
     */
    @Bean
    public RedissonAutoConfigurationCustomizer redissonAutoConfigurationCustomizerCodec() {
        return configuration -> configuration.setCodec(new CloudMsgPackJacksonCodec());
    }

}
