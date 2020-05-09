package com.ip192.javaBaseHelper.thread_test;

import org.junit.Test;

public class SynchronizedTest {

    /**
     * 非静态内部类不能有静态方法、静态属性
     * 外部类初始化时内部类不初始化，内部类的静态属性、方法无法加载
     */
    /**
     * synchronized修饰方法和 synchronized(this)修饰方法中所有代码的代码块一样
     * 对于同一个当前对象 在不同线程中所有同步方法一起被阻塞
     *
     * 当一个线程访问对象的一个synchronized(this)代码块时，其它线程仍然可以访问该对象中的非synchronized(this)代码块。
     *
     * synchronized方法不会被继承
     */
    private class SyncMethodClass {
        synchronized private void printA() {
            int i = 0;
            while (i++ < 100) {
                System.out.println(i + "AAAAA");
            }
        }
        synchronized private void printB() {
            int i = 0;
            while (i++ < 100) {
                System.out.println(i + "BBBBB");
            }
        }
        private void printC() {
            synchronized (this) {
                int i = 0;
                while (i++ < 100) {
                    System.out.println(i + "CCCCC");
                }
            }
        }
    }
    @Test
    public void syncMethodTest() {
        SyncMethodClass syncMethod = new SyncMethodClass();
        Thread t1 = new Thread(() -> syncMethod.printA());
        Thread t2 = new Thread(() -> syncMethod.printB());
        Thread t3 = new Thread(() -> syncMethod.printC());
        t1.start();
        t2.start();
        t3.start();

        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    /**
     * synchronized修饰静态方法被称为类锁，与对象锁不同，互不影响
     * 调用方式存在差异，一个是用类调用 一个是用实例调用
     */
    private static synchronized void stuck() {
        while (true) {
            System.out.println("stuck" + Thread.currentThread().getName());
        }
    }
    private synchronized void normalSynchronized() {
        System.out.println("normal synchronized method");
    }
    private void normal() {
        System.out.println("normal method");
    }
    @Test
    public void staticSyncTest() {
        SyncMethodClass syncMethod = new SyncMethodClass();
        Thread t1 = new Thread(() -> stuck());
        Thread t2 = new Thread(() -> stuck());
        t1.start();t2.start();
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    /**
     * 此处需要的是操作的原子性即同步，而非volatile的实时可见性
     */
    private int index = 0;
    synchronized private void indexAdd() {
        index++;
    }
    @Test
    public void synchronizedTest() throws InterruptedException {
        Thread t1 = new Thread(() -> {
            int i = 0;
            while (i++ < 100) {
                try {
                    Thread.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                indexAdd();
            }
        });
        Thread t2 = new Thread(() -> {
            int i = 0;
            while (i++ < 100) {
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                indexAdd();
            }
        });
        t1.start();
        t2.start();
//        t1.join();t2.join();
        Thread.sleep(1200L);
        System.out.println(index);
    }


    /**
     * volatile
     * 此处需要的是volatile的实时可见性
     * 各线程只从主存读一次变量，之后操作的是当前线程下的缓存，用volatile声明后，一处修改会强制更新各线程数据
     *
     * java -version显示是server模式会优化，volatile作用可能无法体现
     */
    private boolean switcher = true;
    private /*volatile*/ int i = 0;
    @Test
    public void volatileTest() throws InterruptedException {
        Thread thread1 = new Thread(() -> {
            while (switcher) {
//                System.out.println("Open");
                i++;
            }
        });
        Thread thread2 = new Thread(() -> {
            while (switcher) {
//                System.out.println("Open");
                i++;
            }
        });
        thread1.start();
        thread2.start();
        Thread.sleep(100L);
        switcher = false;
        System.out.println("_____" + i);
        Thread.sleep(500L);
        System.out.println("_____" + i);
    }
}
