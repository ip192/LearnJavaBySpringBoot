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


    /**
     * 若要实现对象的自定义顺序比较
     * 要让该类实现comparator接口, 重写compare方法
     */
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


    public void swapTry() {
        List<String> strList = new ArrayList<>();
        strList.add("ab");
        strList.add("cd");
        strList.add("ef");
        strList.add("gh");
        Collections.swap(strList, 0, 3);
        System.out.println(strList);
    }
    @Test
    public void testSwapTry() {
        swapTry();
    }


    /**
     * 获得其中的前n个
     */
    public void getSpecifiedLength() {
        List<Integer> subList = intList.subList(0, 2);
        System.out.println(subList);
        System.out.println(intList);

    }
    @Test
    public void testGetSpecifiedLength() {
        getSpecifiedLength();
    }


    public void trimTry() {
        List<Integer> iList = new ArrayList<>(5);
        iList.add(10);
        iList.add(11);
        iList.add(12);
        System.out.println(iList);
        System.out.println(iList.size());
        // ArrayList 实例的 toArray() 方法是调用的 Arrays.copyOf
        // no reference to the origin
        iList.set(1, 111);
        System.out.println(iList);
    }
    @Test
    public void testTrimTry() {
        trimTry();
    }


    public void addAllTry() {
        List<Integer> iList = new ArrayList<>(Arrays.asList(2, 3, 4, 5));
        List<Integer> jList = new ArrayList<>(Arrays.asList(12, 13, 14, 15));
        iList.addAll(jList);
        System.out.println(iList.subList(3,4));
        iList.set(4, 21);
        System.out.println(iList);
        System.out.println(jList);
        // addAll 并不是拷贝了引用
        // subList 返回的是引用
    }
    @Test
    public void testAddAllTry() {
        addAllTry();
    }


    public void listIteratorTry() {
        ListIterator<Integer> listIterator = intList.listIterator();
//        System.out.println(listIterator.next());
//        System.out.println(listIterator.nextIndex());

//        System.out.println(listIterator.previous());
//        System.out.println(listIterator.previousIndex());

        // ListIterator 的 add() 方法是在当前位置插入
//        listIterator.add(0);
//        System.out.println(intList);
//        listIterator.next();
//        listIterator.next();
//        listIterator.add(0);
//        System.out.println(intList);

        // ListIterator 的 set() 方法是在当前位置替换
        System.out.println(intList);
        listIterator.next();
        listIterator.next();
        listIterator.set(0);
        System.out.println(intList);
    }
    @Test
    public void testListIteratorTry() {
        listIteratorTry();
    }


    private void genericTry() {
        List<Object> objList = new ArrayList<>();

        List<String> strList = new ArrayList<>();
        strList.add("one");
        strList.add("two");
        strList.add("three");

//        objList = (List<Object>) strList; // 编译不通过
        strList.forEach(str -> objList.add(str));
        objList.forEach(obj -> {
            System.out.println(obj);
            System.out.println(obj.getClass());
        });
    }
    @Test
    public void testGenericTry() {
        genericTry();
    }



    private void floatListTry() {
        List<Float> floatList = new ArrayList<>();
        floatList.add((float)2.2);
        floatList.add((float)1.2);
        floatList.forEach(f -> {
            System.out.println(f.intValue());
        });
    }
    @Test
    public void testFloatListTry() {
        floatListTry();
    }
}

class TestObject {
    @Override
    public boolean equals(Object obj) {
        return true;
    }
}