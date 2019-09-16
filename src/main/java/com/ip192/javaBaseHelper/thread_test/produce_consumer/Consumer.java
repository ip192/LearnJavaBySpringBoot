package com.ip192.javaBaseHelper.thread_test.produce_consumer;

public class Consumer implements Runnable {
    private Entity entity;

    public Consumer(Entity entity) {
        this.entity = entity;
    }

    @Override
    public void run() {
        entity.minus();
    }
}
