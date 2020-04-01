package com.ip192.javaBaseHelper.thread_test;

import org.junit.Test;

import java.util.concurrent.Callable;

public class ThreadMethodDemo {

    private class InnerTask implements Callable<String> {

        @Override
        public String call() throws Exception {
            Thread.sleep(300L);
            return "callable task done";
        }
    }



    private class WaitNotify {

        synchronized private void print1() {
            int i = 0;
            while(i < 2) {
                notify();
                i++;
                System.out.println(Thread.currentThread().getName());
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        synchronized private void print2() {
            int i = 0;
            while(i < 2) {
                notify();
                i++;
                System.out.println(2);
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    /**
     * wait/notify
     * 都要放到同步代码块里，wait()通常在loop中使用
     * 在同步代码块里 wait() 会释放锁 进入等待区，notify会从等待区里通知一个
     * sleep是线程的方法，不释放锁
     */
    @Test
    public void waitNotifyTest() {
        WaitNotify waitNotify = new WaitNotify();
        // 要对同一个对象wait/notify
        Thread t1 = new Thread(() -> waitNotify.print1());
        Thread t2 = new Thread(() -> waitNotify.print2());
        // notify会从等待区里通知一个，所以两个可以交互进行，三个会随机出现死锁
//        Thread t3 = new Thread(() -> waitNotify.print1());
        t1.start();
        t2.start();
//        t3.start();
    }


    /**
     * yield
     * 通常只在debug和test时用，交出cpu并与其它线程重新抢占
     */
    @Test
    public void yieldTest() {

    }


    /**
     * join
     * 是同步方法，阻塞当前线程，先执行调用此方法的线程
     * 其中：当前线程是isAlive，主线程对象一直wait
     */
    @Test
    public void joinTest() throws Exception {
        Thread thread = new Thread(() -> System.out.println("join thread"));
        thread.start();
        System.out.println("main thread");
//        thread.join();
        System.out.println("main thread");
    }
}
