package com.ip192.javaBaseHelper.interface_test;

public interface InterfaceTwo {
//    String print(String str);

    default void print() {
        System.out.println("interface one");
    }

    String print(String one);

}
