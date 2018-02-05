package com.ip192.javaBaseHelper.string_test;

import org.junit.Test;

public class StringDemo {

    public void stringEqual() {
//        String a = "string one";
//        String b = "string" + " " + "one";
//        System.out.println(a.equals(b));


        String c = "string\ttwo";
        String d = "string  two";
        System.out.println(c);
        System.out.println(d);
        System.out.println(c.equals(d));
        System.out.println(c == d);
    }
    @Test
    public void testStringEqual() {
        stringEqual();
    }

}
