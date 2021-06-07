package com.ip192.javaBaseHelper.loop_test;

public class DependencyClassB {

    private DependencyClassA classA;

    public DependencyClassB() {
        classA = new DependencyClassA();
    }

    public void printB() {
        System.out.println("this is class B");
        classA.printA();
    }
}
