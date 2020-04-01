package com.ip192.spring.executors;

import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.lang.reflect.Method;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

@Configuration
public class BussinessOneThreadPool {

    @Bean(name = "businessOne")
    public Executor threadPoolTaskExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setThreadNamePrefix("businessOne-thread-");
        executor.setMaxPoolSize(8);
        executor.setCorePoolSize(4);
        executor.setQueueCapacity(0);
        // set exception handler
        RejectedExecutionHandler handler = new RejectedExecutionHandler() {
            @Override
            public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
                System.out.println("businessOne thread pool is full");
            }
        };
        executor.setRejectedExecutionHandler(handler);
        return executor;
    }

}
