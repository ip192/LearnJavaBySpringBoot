package com.ip192.javaBaseHelper.interface_test;

public interface InterfaceOne {

    default void print() {
        System.out.println("interface one print");
    }

    String print(Integer i);

    static void print(String str) {
        System.out.println("interface one static print");
    }
}
