package com.ip192.javaBaseHelper.thread_test;

public class ThreadLocalDemo {

    private static ThreadLocal<String> threadLocalUserId = new ThreadLocal<>();

    public void setUserId(String userId) {
        /**
         * ThreadLocal对象的set实际上是将值set进了当前Thread内维护的一个map(ThreadLocalMap)
         * key是ThreadLocal对象(threadLocalUserId)，value是userId
         */
        threadLocalUserId.set(userId);
    }
}
