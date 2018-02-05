package com.ip192.javaBaseHelper.list_test;

import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;


public class LinkedListDemo {
    LinkedList<Integer> intList = new LinkedList<>(Arrays.asList(1, 2, 3, 4));

    /**
     * add()
     * offer()
     * addFirst/addLast/offerFirst/offerLast
     */
    public void insertTry() {
        intList.add(5);
        // intList.offer(6); // 内部调用add()方法
        intList.add(0, 0);
        System.out.println(intList);
    }
    @Test
    public void testPppTry() {
        insertTry();
    }


    /**
     * remove() first/last
     * poll() first/last
     * pop()
     */
    public void removeTry() {
        System.out.println(intList);

        // intList.remove(); // 内部调用的是removeFirst()方法
        intList.removeFirst();
        System.out.println(intList);

        // poll()方法虽未直接引用pollFirst(), 但内部实现一样
        // 和removeFirst()一样, 但removeFirst()会抛出异常
        // 返回并移除第一个元素
//        System.out.println(intList.poll());
//        System.out.println(intList.pollFirst());

        // pop()方法 内部调用的是removeFirst()方法
        intList.pop();
        System.out.println(intList);
    }
    @Test
    public void testRemoveTry() {
        removeTry();
    }


    /**
     * get() first/last
     * peek() first/last
     * element()
     */
    public void getTry() {
//        System.out.println(intList.getFirst());
//        System.out.println(intList.element()); // 内部调用的是getFirst()方法

        // peek()方法虽未直接引用peekFirst(), 但内部实现一样
        // 返回但不移除第一个元素
//        System.out.println(intList.peek());
//        System.out.println(intList.peekFirst());
    }
    @Test
    public void testGetTry() {
        getTry();
    }


    public void cloneTry() {
        LinkedList<String> strList = new LinkedList<>(Arrays.asList("abc", "def", "ghi"));
        LinkedList<String> cloneList = (LinkedList)strList.clone();
        System.out.println(strList);
        cloneList.set(0, "abcc");
        System.out.println(strList);
        strList.set(0, "cba");
        System.out.println(cloneList);
    }
    @Test
    public void testCloneTry() {
        cloneTry();
    }
}
