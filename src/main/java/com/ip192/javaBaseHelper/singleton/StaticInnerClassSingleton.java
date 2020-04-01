package com.ip192.javaBaseHelper.singleton;

/**
 * 静态内部类
 */
public class StaticInnerClassSingleton {
    private StaticInnerClassSingleton singleton;

    public StaticInnerClassSingleton getInstance() {
        return SingletonHolder.holderSingleton;
    }

    // static线程不安全 即使发生指令重排序 各线程也会更新
    private static class SingletonHolder {
        private static StaticInnerClassSingleton holderSingleton = new StaticInnerClassSingleton();
    }

}
