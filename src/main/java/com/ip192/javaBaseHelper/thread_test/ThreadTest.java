package com.ip192.javaBaseHelper.thread_test;

import com.ip192.javaBaseHelper.thread_test.produce_consumer.Consumer;
import com.ip192.javaBaseHelper.thread_test.produce_consumer.Entity;
import com.ip192.javaBaseHelper.thread_test.produce_consumer.Producer;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;


public class ThreadTest {
    /**
     * Thread.sleep()也可以用TimeUnit.SECONDS.sleep()的方式
     */

    private int num = 1;

    private ThreadLocal<String> threadLocal = new ThreadLocal<>();

    private  int count = 0;

    @Test
    public void threadInfo() throws InterruptedException {
        Thread thread = new Thread() {
            @Override
            public void run() {
                try {
                    System.out.println(this.getId());
                    Thread.sleep(1000);
                    System.out.println("sleep done");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    this.interrupt();
                }
            }
        };
        thread.start();
        thread.join();
        System.out.println(thread.getState());
    }


    private void normalInt() {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + "\t" + num);
                num++;
                System.out.println(Thread.currentThread().getName() + "\t" + num);
            }
        });
        thread.start();
    }
    @Test
    public void TestNormalInt() {
        for (int i = 0; i < 5; i++) {
            normalInt();
        }
    }


    private void threadLocalTry() {
        threadLocal.set("one");
        System.out.println(threadLocal.get());
        threadLocal.set("two");
        System.out.println(threadLocal.get());
    }
    @Test
    public void testThreadLocalTry() {
        for (int i = 0; i < 5; i++) {
            threadLocalTry();
        }

    }


    @Test
    public void producerConsumerTest() {
        Entity entity = new Entity();
        Producer producer = new Producer(entity);
        Consumer consumer = new Consumer(entity);

        for (int a = 0; a < 10; a++) {
            new Thread(producer).start();
        }
        for (int a = 0; a < 10; a++) {
            new Thread(consumer).start();
        }
    }


    @Test
    public void entityTest() throws InterruptedException {
        Entity entity = new Entity();
        Thread t1 = new Thread(() -> entity.setNum(10));
        Thread t2 = new Thread(() -> System.out.println(entity.getNum()));
        t1.start();
        t2.start();
    }


    @Test
    public void stateTest() {
        /**
         * Thread.State.NEW: 创建了，但没start
         * Thread.State.RUNNABLE: 正在运行或等待处理器调用
         * Thread.State.BLOCKED: 等待进入synchronized同步区域
         * Thread.State.WAITING: 调用wait()、join()被要求等待
         * Thread.State.TIMED_WAITING: 调用了指定时长的sleep()、join()、wait()
         * Thread.State.TERMINATED: 运行结束
         */
    }


    @Test
    public void daemonTest() {
        /**
         * 非守护线程全部执行完毕，守护线程也就退出了
         * 守护线程随时有可能中断，守护线程创建的都是守护线程
         */
    }
}
