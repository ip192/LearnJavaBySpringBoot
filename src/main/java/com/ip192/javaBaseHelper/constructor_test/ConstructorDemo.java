package com.ip192.javaBaseHelper.constructor_test;

import org.junit.Test;

/**
 * 不要使用双括号初始化
 * 会产生不能再次使用的对象
 * http://deepinmind.iteye.com/blog/2165827
 */
public class ConstructorDemo {

    @Test
    public void testConstructor() {
        Cons1 cons1 = new Cons1(){{
            print();
        }};
    }
}


class Cons1 {
    {
        System.out.println("代码块初始化");
    }
    Cons1() {
        System.out.println("Cons1 constructor");
    }
    void print() {
        System.out.println("print method");
    }
}
