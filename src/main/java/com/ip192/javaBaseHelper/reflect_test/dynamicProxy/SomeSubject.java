package com.ip192.javaBaseHelper.reflect_test.dynamicProxy;

public class SomeSubject implements SomeInterface {
    @Override
    public void someMethod() {
        System.out.println("some subject some method");
    }
}
