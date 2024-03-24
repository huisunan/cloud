package io.github.hsn.cloud.common.security.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "cloud.security")
public class SecurityProperties {

    private String jwtKey = "jwtKey";
}
