package io.github.hsn.cloud.common.security.component;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;

import java.util.function.Consumer;

public interface CloudCustomHttpSecurity {
    void accept(HttpSecurity httpSecurity);
}
