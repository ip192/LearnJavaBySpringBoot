package com.ip192.javaBaseHelper.lock_test;

import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Semaphore与ReadLock相比，多了设置state上限的逻辑
 */
public class SemaphoreTest {
    public static final Integer MAX = 4;
    private Semaphore syncAmount = new Semaphore(3);
    private volatile Integer resources = MAX;

    public Semaphore getAmount() {
        return syncAmount;
    }

    public int getResources() {
        return resources;
    }
    public synchronized void addResources() {
        resources++;
        notify();
    }
    public synchronized void useResources() {
        while (resources == 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        resources--;
    }

    public static void main(String[] args) {
        // 生产者消费者
        SemaphoreTest test = new SemaphoreTest();
        new Thread(new Producer(test), "Producer").start();
        for (int i = 1; i <= 40; i ++) {
            new Thread(new Consumer(test), "Consumer-" + i).start();
        }
    }
}

class Producer implements Runnable {
    private SemaphoreTest semaphore;

    public Producer(SemaphoreTest semaphore) {
        this.semaphore = semaphore;
    }

    @Override
    public void run() {
        int total = 0;
        try {
            for (;;) {
                semaphore.getAmount().release();
                if (semaphore.getResources() < SemaphoreTest.MAX) {
                    Thread.sleep(7L);
                    semaphore.addResources();
                    System.out.println(Thread.currentThread().getName() + " produce");
                    total++;
                }
                if (total == 40) {
                    return;
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
class Consumer implements Runnable {
    private SemaphoreTest semaphore;

    public Consumer(SemaphoreTest semaphore) {
        this.semaphore = semaphore;
    }

    @Override
    public void run() {
        try {
            semaphore.getAmount().acquire();
            for (;;) {
                if (semaphore.getResources() > 0) {
                    Thread.sleep(20L);
                    semaphore.useResources();
                    System.out.println(Thread.currentThread().getName() + " consume");

                    break;
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            semaphore.getAmount().release();
        }
    }
}
