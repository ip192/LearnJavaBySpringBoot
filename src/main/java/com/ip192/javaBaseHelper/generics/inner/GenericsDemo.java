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


    /**
     * 子类实例调用未重写方法，即调用父类中的方法，此父类方法中调用的方法若被重写，则调用的是子类重写后的方法
     * 对象为子类实例，调用的方法以子类中的优先
     */
    @Test
    public void  parentSonMethodTest() {
        Son son = new Son();
        son.say();
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

    // abstract方法还不确定子类实现逻辑，加synchronized无意义
//    abstract synchronized void failed(){}

    protected void sayEnglish() {
        System.out.println("parent speak English");
    }
    protected void sayChinese() {
        System.out.println("parent speak Chinese");
    }
    protected void say() {
        System.out.println("parent say");
        sayEnglish();
        sayChinese();
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

    protected void sayEnglish() {
        System.out.println("son speak English");
    }
    protected void sayChinese() {
        System.out.println("son speak Chinese");
    }
}