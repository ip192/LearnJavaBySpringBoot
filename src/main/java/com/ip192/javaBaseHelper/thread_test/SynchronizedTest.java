package com.ip192.javaBaseHelper.thread_test;

import org.junit.Test;

public class SynchronizedTest {
    /**
     * synchronized修饰方法和 synchronized(this)修饰方法中所有代码的代码块一样
     * 对于同一个当前对象 在不同线程中要同步执行此方法
     */

    /**
     * 当一个线程访问对象的一个synchronized(this)代码块时
     * 另一个线程仍然可以访问该对象中的非synchronized(this)代码块。
     */

    /**
     * synchronized方法不会被继承
     */

    /**
     * synchronized修饰静态方法 因静态方法与对象无关 此静态方法锁定的是所有实例对象
     */


    // volatile
    private volatile int index = 0;
    @Test
    public void volatileTest() throws InterruptedException {
        Thread t1 = new Thread(() -> {
            while (index < 100) {
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                index++;
            }
        });
        Thread t2 = new Thread(() -> {
            while (index < 100) {
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                index++;
            }
        });
        t1.start();
        t2.start();
        Thread.sleep(1000);
        System.out.println(index);
    }

}