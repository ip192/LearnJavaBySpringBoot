package com.ip192.javaBaseHelper.thread_test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

public class
CallableClass implements Callable<List<String>> {
    private long sleepSec = 200L;

    public CallableClass() {
    }

    public CallableClass(long sleepSec) {
        this.sleepSec = sleepSec;
    }

    @Override
    public List<String> call() throws Exception {
        Long millSec = System.currentTimeMillis();
        List<String> millSecList = new ArrayList<>();
        String millSecArr[] = millSec.toString().split("");
        for (int i = 0; i < millSecArr.length - 1; i++) {
            millSecList.add(millSecArr[i]);
        }
        Thread.sleep(sleepSec);
        System.out.println("call done");
        return millSecList;
    }
}
