package com.ip192.javaBaseHelper.thread_test;

import com.ip192.javaBaseHelper.thread_test.produce_consumer.Consumer;
import com.ip192.javaBaseHelper.thread_test.produce_consumer.Entity;
import com.ip192.javaBaseHelper.thread_test.produce_consumer.Producer;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;


public class ThreadTest {

    private int num = 1;

    private ThreadLocal<String> threadLocal = new ThreadLocal<>();

    private  int count = 0;

    private void threadInfo() {
        Thread thread = new Thread() {
            @Override
            public void run() {
                System.out.println(this.getId());
            }
        };
        thread.start();
        System.out.println(thread.getState());
    }
    @Test
    public void testThreadInfo() {
        threadInfo();
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

}
