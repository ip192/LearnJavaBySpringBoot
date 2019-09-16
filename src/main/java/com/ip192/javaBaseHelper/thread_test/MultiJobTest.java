package com.ip192.javaBaseHelper.thread_test;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class MultiJobTest {
    // 不借助volatile
    private volatile AtomicInteger i = new AtomicInteger(0);
    private AtomicInteger j = new AtomicInteger(0);
    private Integer k = 0;

    @Test
    public void loopTest() {
        for (int a = 0; a < 5; a++) {
            new Thread(() -> {
//                i.getAndIncrement();
//                System.out.println(Thread.currentThread().getName() + " - " + i.get());

                j.getAndIncrement();
                System.out.println(Thread.currentThread().getName() + " - " + j.get());

//                k++;
//                System.out.println(Thread.currentThread().getName() + " - " + k);
            }).start();
        }
    }


    private Integer getResult() {
        new Thread(() -> {
            try {
                int a = 0 / i.getAndIncrement();
                System.out.println(a);
            } catch (Exception e) {
                i.set(2);
                e.printStackTrace();
            } finally {
                i.set(3);
            }
        }).start();

        return i.get();
    }

    @Test
    public void exceptionTest() {
        System.out.println(getResult());
    }


    @Test
    public void multiCallableTest() {
        List<String> resList = new ArrayList<>(64);

        ExecutorService executorService = Executors.newFixedThreadPool(3);

        /**
         * 此处可以根据4个任务总耗时看出
         * 线程池中只有3个线程 先执行前三个任务 第一个执行完的负责执行第四个
         * 所以total = max(max(t1..t3), min(t1..t3) + t4)
         */
        System.out.println(System.currentTimeMillis());
        Future task1 = executorService.submit(new CallableClass(200L));
        Future task2 = executorService.submit(new CallableClass(300L));
        Future task4 = executorService.submit(new CallableClass(500L));
        Future task3 = executorService.submit(new CallableClass(400L));
        try {
            while (true) {
                if (task1.isDone() && task2.isDone() && task3.isDone() && task4.isDone()) {
                    // 调用get()方法时才会执行call里面的逻辑
                    resList.addAll((List<String>)task1.get());
                    resList.addAll((List<String>)task2.get());
                    resList.addAll((List<String>)task3.get());
                    resList.addAll((List<String>)task4.get());
                    executorService.shutdown();
                    break;
                }
            }
            System.out.println(System.currentTimeMillis());
            System.out.println(resList.size());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }
}
