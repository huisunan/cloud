package io.github.hsn.cloud.upms;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan
@SpringBootApplication
@EnableDubbo
public class CloudUpmsApplication {
    public static void main(String[] args) {
        SpringApplication.run(CloudUpmsApplication.class, args);
    }
}
