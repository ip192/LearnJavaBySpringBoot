package com.ip192.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan(basePackages = "com.ip192.spring")
public class Entrance {
    /**
     * 可以在此入口开启异步 @EnableAsync
     * 借助一个@Configuration配置类用于async任务的线程池 ThreadPoolTaskExecutor
     * 使用@async时指定线程池名称
     */

    public static void main(String[] args) {
        SpringApplication.run(Entrance.class, args);
    }
}
