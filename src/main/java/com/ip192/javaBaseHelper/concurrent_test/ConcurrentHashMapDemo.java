package com.ip192.javaBaseHelper.concurrent_test;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapDemo {
//    private Map<Integer, Long> cMap = new ConcurrentHashMap<>();
    private Map<Integer, Long> map = new ConcurrentHashMap<>();

    private Thread getThread(Long mills) {
        return new Thread(() -> {
            while (map.size() < 100) {
                try {
                    Thread.sleep(mills);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                map.put(map.size() + 1, System.currentTimeMillis());
            }
        });
    }
    @Test
    public void concurrentTest() throws InterruptedException {
        Thread t1 = getThread(1L);
        Thread t2 = getThread(5L);
        t1.start();
        t2.start();
        Thread.sleep(1000);
        System.out.println(map.size());
    }
}
