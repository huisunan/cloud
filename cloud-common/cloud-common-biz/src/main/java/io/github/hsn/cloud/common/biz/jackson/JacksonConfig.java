package io.github.hsn.cloud.common.biz.jackson;

import cn.hutool.core.date.DatePattern;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.boot.autoconfigure.jackson.JacksonAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Locale;
import java.util.TimeZone;

@Configuration
@AutoConfigureBefore(JacksonAutoConfiguration.class)
public class JacksonConfig {
    @Bean
    public Jackson2ObjectMapperBuilderCustomizer customizer() {
        return builder -> {
            builder.locale(Locale.CHINA);
            builder.timeZone(TimeZone.getTimeZone("Asia/Shanghai"));
            builder.simpleDateFormat(DatePattern.NORM_DATETIME_PATTERN);
            builder.modules(new CloudJavaTimeModule());
        };
    }
}
