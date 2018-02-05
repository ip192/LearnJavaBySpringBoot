package com.ip192.javaBaseHelper.map_test;

import org.junit.Test;

import java.util.LinkedHashMap;

public class LinkedHashMapDemo {

    public void baseTry() {
        LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put("one", "1");
        linkedHashMap.put("two", "2");
        linkedHashMap.put("three", "3");
        System.out.println(linkedHashMap);
    }
    @Test
    public void testBaseTry() {
        baseTry();
    }
}
