package com.ip192.javaBaseHelper.map_test;

import org.junit.Test;

import java.util.Collections;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class TreeMapDemo {

    public void reverseCompare() {
        Map<String, String> reverseMap = new TreeMap<>(Collections.reverseOrder());
        reverseMap.put("a", "1");
        reverseMap.put("b", "2");
        reverseMap.put("c", "3");
        reverseMap.put("d", "4");
        System.out.println(reverseMap);


        // TreeMap默认是按照key的升序排序的
        Map<String, String> map = new TreeMap<>();
        map.put("a", "1");
        map.put("b", "2");
        map.put("c", "3");
        map.put("d", "4");
        System.out.println(map);
    }
    @Test
    public void testReverseCompare() {
        reverseCompare();
    }



    public void diyCompareTry() {
        Comparator<String> comparator = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.toLowerCase().compareTo(o2.toLowerCase());
            }
        };

        Map<String, String> treeMap = new TreeMap<>(comparator);
        treeMap.put("one2", "1");
        treeMap.put("two2", "2");
        treeMap.put("One1", "1");
        treeMap.put("Two1", "2");
        treeMap.put("THREE", "3");
        System.out.println(treeMap);
    }
    @Test
    public void testDiyCompareTry() {
        diyCompareTry();
    }



    public void subMapTry() {
        TreeMap<String, String> treeMap = new TreeMap<>();
        treeMap.put("tree1", "map1");
        treeMap.put("tree2", "map2");
        treeMap.put("tree3", "map3");
        treeMap.put("tree4", "map4");
        treeMap.put("tree5", "map5");
        System.out.println(treeMap.subMap("tree2", "tree4"));
        System.out.println(treeMap);
    }
    @Test
    public void testSubMapTry() {
        subMapTry();
    }
}
