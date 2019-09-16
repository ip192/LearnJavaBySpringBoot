package com.ip192.javaBaseHelper.thread_test.produce_consumer;

public class Entity {
    private Integer num = 0;

    public synchronized void add() {
        while (num == 4) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        num++;
        System.out.println("add 1,  num: " + num);
        notify();
    }

    public synchronized void minus() {
        while (num == 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        num--;
        System.out.println("minus 1,  num: " + num);
        notify();
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }
}
