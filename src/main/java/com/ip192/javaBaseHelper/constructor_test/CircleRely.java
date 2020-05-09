package com.ip192.javaBaseHelper.constructor_test;

import org.junit.Test;


/**
 * 若是Spring管理的单例Bean则不会循环new
 */
public class CircleRely {

    @Test
    public void constructorTest() {
        new ClassA().say();
        new ClassB().say();
    }
}

class ClassA {
    private ClassB b = new ClassB();

    public void say() {
        System.out.println("class a");
    }
}

class ClassB {
    private ClassA a = new ClassA();

    public void say() {
        System.out.println("class b");
    }
}
