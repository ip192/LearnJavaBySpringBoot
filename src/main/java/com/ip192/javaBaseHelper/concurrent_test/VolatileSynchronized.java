package com.ip192.javaBaseHelper.concurrent_test;

public class VolatileSynchronized {

    /**
     * volatile是确保多线程操作同一个变量时，数据保持一致，一个线程修改，其他线程要更新
     * synchronized是确保多个线程要执行一段修改逻辑时，同一时刻只能有一个线程对其操作，并将改动刷新到主存中
     * Lock要手动加锁手动释放，可以尝试获取锁，可以加读锁和写锁
     */

    private Integer a = 1;

    synchronized public void changeA() {

    }


    volatile private Integer b = 1;

    public void changeB() {

    }

}
