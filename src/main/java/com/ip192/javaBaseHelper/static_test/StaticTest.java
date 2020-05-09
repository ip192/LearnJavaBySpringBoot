package com.ip192.javaBaseHelper.static_test;

public class StaticTest {
    /**
     * 静态方法/属性 不会被序列化
     */
    private static final String strA;
    private static final String strB;
    private static String strC;
    private static String strD = "strAstrB"; // 1.静态变量初始化
    private String blank = "blank"; // 3.成员变量初始化

    {
        System.out.println("code block"); // 4.普通代码块初始化
    }

    StaticTest() {
        System.out.println("constructor"); // 5.执行构造方法
    }

    static { // 2.静态代码块初始化
        strA = "strA";
        strB = "strB";
        System.out.println("static code block");
    }

    static String getConcat() {
        strC = strA + strB;
        return strC;
    }

    static String getStrD() {
        return strD;
    }

}
