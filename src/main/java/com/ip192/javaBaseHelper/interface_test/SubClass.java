package com.ip192.javaBaseHelper.interface_test;

public class SubClass implements InterfaceOne, InterfaceTwo {
//    @Override
//    public String print(String str) {
//        return null;
//    }

    @Override
    public void print() {

    }

    @Override
    public String print(Integer one) {
        InterfaceOne.print("one");
        return null;
    }

    @Override
    public String print(String two) {
        /**
         * 接口中的default方法是相当于抽象类中已实现了的方法，可以直接调用或重写
         * 两个接口只有一个有default print()方法，则调用时方法明确
         * 两个接口中都存在default print()方法，若不重写则此处调用不明确
         */
        print();

        return null;
    }
}
