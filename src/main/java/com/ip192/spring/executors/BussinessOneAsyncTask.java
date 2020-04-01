package com.ip192.spring.executors;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class BussinessOneAsyncTask {

    @Async("businessOne")
//    @Scheduled(cron = "0/1 * * * * ?")
    public void doAsyncTask() {
        System.out.println(Thread.currentThread().getName());
        while (true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
