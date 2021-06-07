package com.ip192.javaBaseHelper.loop_test;

public class DependencyClassA {
    private DependencyClassB classB;

    public DependencyClassA() {
        classB = new DependencyClassB();
    }

    public void printA() {
        System.out.println("this is class A");
        classB.printB();
    }
}
