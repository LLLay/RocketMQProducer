package com.tt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

/**
 * @Author tongshuo
 * @Data 2020/7/29
 * @Describe
 */
@SpringBootApplication
@ComponentScan(basePackages = {"com.tt.*"})
public class RocketMQApplication extends SpringBootServletInitializer {
    public static void main(String[] args) {
        SpringApplication.run(RocketMQApplication.class, args);
    }
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application){
        return application.sources(RocketMQApplication.class);
    }
}
