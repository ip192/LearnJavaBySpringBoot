package com.ip192.javaBaseHelper.thread_test.produce_consumer;

public class Producer implements Runnable {
    private Entity entity;

    public Producer(Entity entity) {
        this.entity = entity;
    }

    @Override
    public void run() {
        entity.add();
    }
}
