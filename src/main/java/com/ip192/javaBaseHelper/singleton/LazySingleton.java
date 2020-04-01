package com.ip192.javaBaseHelper.singleton;

/**
 * 懒汉模式
 */
public class LazySingleton {
    /**
     * 防止指令重排序
     * 1.创建实例到一块内存
     * 2.指针指向该内存
     * 重排序会导致返回空内存
     */
    private static volatile LazySingleton single;

    public LazySingleton() {
    }

    public static LazySingleton getInstance() {
        // 用2个if包裹synchronized保证此部分逻辑为同步
        if (single == null) {
            synchronized (LazySingleton.class) {
                if (single == null) {
                    single = new LazySingleton();
                }
            }
        }
        return single;
    }
}
