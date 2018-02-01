package com.ip192.javaBaseHelper.array_test;

import org.junit.Test;

import java.util.*;

class Demo {}

public class ArrayDemo1 {

    /**
     * new ArrayList<>() 返回的是可变的集合
     * Arrays.asList() 返回的是一个原数组的变形(引用)
     */
    public void arrayToArrayList() {
        Demo[] demoArray = {new Demo(), new Demo(), new Demo()};

        ArrayList<Demo> al = new ArrayList<>(Arrays.asList(demoArray));
        al.add(new Demo());
        System.out.println(al.size());

        List l = Arrays.asList(demoArray);
        // l.add(new Demo()); 数组越界
        demoArray[2] = null;
        System.out.println(l.get(2));

        System.out.println(al.get(2) instanceof Demo);
    }
    @Test
    public void testArrayToArrayList() {
        arrayToArrayList();
    }


    /**
     * 打印数组矩阵
     */
    public void arrayPrintN() {

    }
    @Test
    public void testArrayPrintN() {

    }


    /**
     * HashMap 测试
     */
    public void hashMap() {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "word a");
        map.put(2, "word b");
        map.put(3, "word c");
        map.put(4, "word d");
        map.put(5, "word e");

        // entry
        for (Map.Entry entry: map.entrySet()) {
            System.out.println("key: " + entry.getKey() + "\t" + "value: " + entry.getValue());
        }
        // key
        for (Integer key: map.keySet()) {
            System.out.println("key: " + key);
        }
        // value
        for (String value: map.values()) {
            System.out.println("value: " + value);
        }
        // iterator
        Iterator iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry entry = (Map.Entry) iterator.next();
            System.out.println("key: " + entry.getKey() + "\t" + "value: " + entry.getValue());
        }

        map.remove(4, "word"); // value 与 key 对应不上 删除失败
        map.forEach((key, value) -> System.out.println(key + "\t" + value));

        HashMap<Integer, String> mapp = new HashMap<>();
        mapp.put(4, "word c");
        mapp.put(5, "word e");
        map.putAll(mapp);
        map.forEach((key, value) -> System.out.println(key + "\t" + value));
    }
    @Test
    public void testHashMap() {
        hashMap();
    }
}
