package com.ip192.javaBaseHelper.try_catch_test;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

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


    /**
     * 返回结果为值时，finally将str改变为新值，但返回的仍是旧值
     * 返回结果为对象时，finally改变对象的属性，生效
     * 返回结果为对象时，finally改变对象引用，返回的仍是旧对象
     */
    public String valueReturn() { // try
        String str = "out";
        try {
            str = "try";
            return str;
        } catch (Exception e) {
            str = "catch";
            return str;
        } finally {
            str = "finally";
        }
    }
    public Map<String, String> objReturn() { // {obj=finally}
        Map<String, String> obj = new HashMap<>();
        try {
            obj.put("obj", "try");
            return obj;
        } catch (Exception e) {
            obj.put("obj", "catch");
            return obj;
        } finally {
            obj.put("obj", "finally");
        }
    }
    public Map<String, String> newObjReturn() { // {obj=try}
        Map<String, String> obj = new HashMap<>();
        try {
            obj.put("obj", "try");
            return obj;
        } catch (Exception e) {
            obj.put("obj", "catch");
            return obj;
        } finally {
            obj = new HashMap<>();
            obj.put("obj", "finally");
        }
    }
    @Test
    public void returnTest() {
        System.out.println(valueReturn());
        System.out.println(objReturn());
        System.out.println(newObjReturn());
    }
}
