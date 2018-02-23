package com.ip192.javaBaseHelper.generics;


import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
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
}


class Parent {

}
class Son extends Parent {
    @Override
    public String toString() {
        return "this is son";
    }
}