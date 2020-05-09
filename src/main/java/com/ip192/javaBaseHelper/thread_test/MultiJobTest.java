package com.ip192.javaBaseHelper.thread_test;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 线程安全三大特性：原子性，有序性，可见性
 */
public class MultiJobTest {
    private Integer k = 0;
    private static Integer m = 0;
    // volatile要求对变量的写入不依赖当前值
    private volatile Integer j = 0;
    private AtomicInteger i = new AtomicInteger(0);

    @Test
    public void loopTest() {
        for (int a = 0; a < 15; a++) {
            new Thread(() -> {
//                System.out.println(Thread.currentThread().getName() + " - " + i.getAndIncrement());

                System.out.println(Thread.currentThread().getName() + " - " + j++);

//                System.out.println(Thread.currentThread().getName() + " - " + k++);

//                System.out.println(Thread.currentThread().getName() + " - " + m++);
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

        // FutureTask实现了Future接口，可中断
        List<Future<List<String>>> futureList = new ArrayList<>();

        // 可以强转调用ThreadPoolExecutor方法
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        /**
         * 此处可以根据4个任务总耗时看出
         * 线程池中只有3个线程 先执行前三个任务 第一个执行完的负责执行第四个
         * 所以total = max(max(t1..t3), min(t1..t3) + t4)
         */
        System.out.println(System.currentTimeMillis());
        Future<List<String>> task1 = executorService.submit(new CallableClass(200L));
        Future<List<String>> task2 = executorService.submit(new CallableClass(300L));
        Future<List<String>> task4 = executorService.submit(new CallableClass(500L));
        Future<List<String>> task3 = executorService.submit(new CallableClass(400L));
        futureList.add(task1);
        futureList.add(task2);
        futureList.add(task3);
        futureList.add(task4);
        try {
//            List<String> taskList1 = task1.get();
//            List<String> taskList2 = task2.get();
//            List<String> taskList3 = task3.get();
//            List<String> taskList4 = task4.get();
            for (Future<List<String>> task : futureList) {
                // 调用get()方法时才会执行call里面的逻辑，会阻塞直到获得结果
                resList.addAll(task.get());
            }
            System.out.println(System.currentTimeMillis());
            System.out.println(resList.size());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    @Test
    public void multiJobCreateObject() throws ExecutionException, InterruptedException {
        ExecutorService pool = Executors.newCachedThreadPool();
        Future<List<String>> task = pool.submit(new CallableClass(500L));
        System.out.println(System.currentTimeMillis());
        int i = 0;
        List<String> list = new ArrayList<>();
        while (i++ < 10000) {
            list.add(System.currentTimeMillis() + "");
        }
        System.out.println(System.currentTimeMillis());
        list.addAll(task.get());

        System.out.println(list.size());
        System.out.println(System.currentTimeMillis());

    }


    @Test
    public void fixedPoolTest() {
        ExecutorService pool = Executors.newFixedThreadPool(2);
        pool.execute(new MyThread());
        pool.execute(new MyThread());
        pool.execute(new MyThread());
        pool.execute(new MyThread());
        pool.execute(new MyThread());

        retry:
        System.out.println("ioc");
    }

}

class MyThread implements Runnable {

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }
}
