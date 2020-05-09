package com.ip192.javaBaseHelper.lock_test;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockTest {
    /**
     * 非公平锁，每次都要竞争，没有先来后到
     * 公平锁，按先来后到排序
     */
    private ReentrantLock unfairLock = new ReentrantLock();

    public ReentrantLock getUnfairLock() {
        return unfairLock;
    }

    public void blockGetLockTest(int i) {
        System.out.println("进入阻塞方法");
        try {
            unfairLock.lock(); // 阻塞
            Thread.sleep(500L);
            System.out.println("阻塞 获得第" + i + "个锁");
            if (i <= 4) {
                blockGetLockTest(i + 1);
            }
            Thread.sleep(500L);
            System.out.println("阻塞 释放第" + i + "个锁");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            if (unfairLock.isLocked()) {
                unfairLock.unlock();
            }
        }

    }
    public void onceGetLockTest() {
        System.out.println("进入非阻塞方法");
        try {
            if (unfairLock.tryLock(5500, TimeUnit.MILLISECONDS)) {
                System.out.println("非阻塞 获得锁");
                Thread.sleep(1000L);
                System.out.println("非阻塞 释放锁");
                unfairLock.unlock();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {

        }

    }

    public static void main(String[] args) throws InterruptedException {
        ReentrantLockTest test = new ReentrantLockTest();
        Thread t1 = new Thread(test::onceGetLockTest);
        Thread t2 = new Thread(() -> test.blockGetLockTest(0));
        t1.start();
        Thread.sleep(10L);
        t2.start();
    }


}
