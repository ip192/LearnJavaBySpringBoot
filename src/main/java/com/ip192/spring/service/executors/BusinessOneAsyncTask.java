package com.ip192.spring.service.executors;

import com.ip192.spring.entity.User;
import com.ip192.spring.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BusinessOneAsyncTask {
    @Autowired
    private UserMapper userMapper;

    /**
     * Scheduled注解默认是单线程，可实现SchedulingConfigurer使用线程池
     * 异常：可以在定义线程池处定义ExceptionHandler，或对有返回值的get进行try/catch
     *
     * Async 注解与 Transactional 注解连用，则调用此方法时只会回滚异步方法
     */
//    @Async("businessOne")
    @Transactional
//    @Scheduled(cron = "0/10 * * * * ?")
    public void doAsyncTask() {
        System.out.println(Thread.currentThread().getName());
//        while (true) {
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
        User user = new User();
        user.setAge(25);
        user.setName("four");
        userMapper.insertOne(user);
        System.out.println(1/0);
    }
}
