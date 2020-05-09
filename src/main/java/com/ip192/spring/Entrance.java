package com.ip192.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @SpringBootApplication中的@EnableAutoConfiguration可以将所有@Configuration加载到容器里
 * @Import注解可用于将多个配置信息类导入一个汇总配置类里 在getApplicationContext时通过一个入口就可以访问到其他导入的各个配置
 */
@EnableAsync
@EnableScheduling
@EnableTransactionManagement
@SpringBootApplication
@ServletComponentScan(basePackages = "com.ip192.spring")
public class Entrance {
    /**
     * 可以在此入口开启异步 @EnableAsync
     * 借助一个@Configuration配置类用于指定@Async任务的线程池 ThreadPoolTaskExecutor
     * 使用@Async时指定线程池名称
     */

    public static void main(String[] args) {
        SpringApplication.run(Entrance.class, args);
    }
}
