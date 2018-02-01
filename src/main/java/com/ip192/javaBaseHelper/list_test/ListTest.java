package com.ip192.javaBaseHelper.list_test;

import org.junit.Test;

import java.util.*;

/**
 * Collection 每个位置只能保存一个元素(对象)
 * Map保存的是"键值对"，就像一个小型数据库。我们可以通过"键"找到该键对应的"值"
 * @author http://www.cnblogs.com/LittleHann/p/3690187.html
 */
public class ListTest {
    private List<TestObject> list = new ArrayList<>(3);
    {
        list.add(new TestObject());
        list.add(new TestObject());
    }

    public void indexOfTry() {
        // indexOf 调用 equals方法
        System.out.println(list.indexOf(new TestObject()));
//        System.out.println(list.get(2));

        System.out.println(intList.get(1));
    }
    @Test
    public void testIndexOfTry() {
        indexOfTry();
    }


    private List<Integer> intList = new ArrayList<>();
    {
        intList.add(1);
        intList.add(2);
        intList.add(3);
    }
    public void addRemoveTry() {
        System.out.println(intList);
        intList.add(0, 0);
        System.out.println(intList);
        intList.add(4);
        System.out.println(intList);
//        intList.add(9, 9);
//        System.out.println(intList);

        // 参数为int, 会调用remove(index)方法;
        // 参数为int包装类, 会调用remove(obj)方法
        intList.remove((Integer)5);
        System.out.println(intList);
        intList.remove( 4);
        System.out.println(intList);
    }
    @Test
    public void testAddRemoveTry() {
        addRemoveTry();
    }


    public void sortTry() {
        List<String> strList = new ArrayList() {{
            add("c");
            add("b");
            add("a");
        }};
        System.out.println(strList);
        Collections.sort(strList);
        System.out.println(strList);
    }
    @Test
    public void testSortTry() {
        sortTry();
    }


    public void removeTry() {
        List<Integer> iList = new ArrayList<>(Arrays.asList(5, 4, 4, 3, 2, 2, 1));
        List<Integer> jList = new ArrayList<>(Arrays.asList(3, 2, 1));
        iList.removeAll(jList);
        System.out.println(iList);
    }
    @Test
    public void testRemoveTry() {
        removeTry();
    }


    public void loopTry() {
        // iterator
        // while(iterator.hasNext()) {}

        // forEach
        // for (Type item: list) {}
    }
    @Test
    public void testLoopTry() {
        loopTry();
    }
}

class TestObject {
    @Override
    public boolean equals(Object obj) {
        return true;
    }
}