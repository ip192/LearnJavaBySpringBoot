package com.ip192.javaBaseHelper.enum_test;

public class EnumTest {

    enum SortEnum { ASC, DESC };

}

class EnumMain {
    public static void main(String[] params) {
        System.out.println(EnumTest.SortEnum.ASC);
    }
}