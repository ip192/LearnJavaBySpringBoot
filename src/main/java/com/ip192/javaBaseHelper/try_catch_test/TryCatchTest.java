package com.ip192.javaBaseHelper.try_catch_test;

import org.junit.Test;

public class TryCatchTest {

    public String method() {

        String str = "output ";

        try {
            new Integer(str);
            System.out.println(str + "try");
            return str + "try";
        } catch (Exception e) {
            System.out.println(str + "catch");
            return str + "catch";
        } finally {
            System.out.println(str + "finally");
            return str + "finally";
        }

    }

    @Test
    public void test() {
        System.out.println(method());
    }

    public String tryFinallyReturn() {
        String str = "out";
        try {
            str = "try";
            return str;
        } catch (Exception e) {

        } finally {
            str = "finally";
            return str;
        }
    }
    @Test
    public void returnTest() {
        System.out.println(tryFinallyReturn());
    }
}
