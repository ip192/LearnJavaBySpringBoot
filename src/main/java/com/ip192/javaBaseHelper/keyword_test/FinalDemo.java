package com.ip192.javaBaseHelper.keyword_test;

public class FinalDemo {

    /**
     * final method 不能被重写
     */
    public final void say() {
        System.out.println("parent final say");
    }
}

class Sub extends FinalDemo {
    public void speak() {
        say();
    }

//    public void say() {
//
//    }
}

