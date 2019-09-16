package com.ip192.javaBaseHelper.static_test;

public class StaticTest {
    /**
     * 静态方法/属性 不会被序列化
     */
    private static final String strA;
    private static final String strB;
    private static String strC;
    private static String strD = "strAstrB";

    {
        System.out.println("code block");
    }

    static {
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

    public static void main(String[] args) {
        System.out.println(StaticTest.getStrD() == "strAstrB");
        System.out.println(StaticTest.getConcat() == "strAstrB");

        new StaticTest();
    }
}
