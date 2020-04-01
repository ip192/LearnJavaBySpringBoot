package com.ip192.javaBaseHelper.generics.inner;


import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 范型尝试
 */
public class GenericsDemo<T extends Iterator> {

    public void listTry() {
        List<? super Parent> list = new ArrayList<>();
        list.add(new Son());
        System.out.println(list);

    }
    @Test
    public void testListTry() {
        listTry();
    }

    static void mid() {
        System.out.println("mid");
    }

    @Test
    public void inheritTest() {
        Parent entity = new Son();
        entity = new Parent();
    }

}


class Parent {

    Parent() {
        System.out.println("parent constructor");
    }

    // 静态方法脱离类存在，所以不受父类子类关系影响
    static void parentPrint() {
        System.out.println("parent static");
    }

}
class Son extends Parent {

    Son() {
        System.out.println("son constructor");
    }

    static void sonPrint() {
        System.out.println("son static");
    }

    @Override
    public String toString() {
        return "this is son";
    }
}