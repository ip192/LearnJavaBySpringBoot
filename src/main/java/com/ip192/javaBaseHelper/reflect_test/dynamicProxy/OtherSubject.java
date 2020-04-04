package com.ip192.javaBaseHelper.reflect_test.dynamicProxy;

public class OtherSubject implements SomeInterface {
    @Override
    public void someMethod() {
        System.out.println("other subject some method");
    }
}
