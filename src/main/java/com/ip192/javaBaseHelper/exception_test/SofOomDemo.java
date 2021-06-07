package com.ip192.javaBaseHelper.exception_test;

import org.aopalliance.aop.AspectException;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * StackOverflow and OutOfMemory Exception
 */
public class SofOomDemo {

    public void oom() {
        List<Object> objectList = new ArrayList<>();
        try {
            while (true) {
                objectList.add(new Object());
            }
        } catch (Exception e) {
            System.out.println("message: " + e.getMessage());
            System.out.println("size: " +objectList.size());
        }
    }
    @Test
    public void oomTest() {
        oom();
    }


    private int index = 0;
    public void sof() {
        index++;
        sof();
    }
    @Test
    public void sofTest() {
        sof();
    }


    public void throwException() {
//        throw new NullPointerException();
        throw new AspectException("aspect");
    }
    @Test
    public void exceptionThrowTest() {
        try {
            throwException();
        } catch (RuntimeException runtimeException) {
            if (runtimeException instanceof NullPointerException) {
                System.out.println("catch null pointer exception");
            } else {
                throw runtimeException;
            }
        } catch (Exception e) {
            System.out.println("catch exception");
        }
    }
}
