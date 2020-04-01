package com.ip192.javaBaseHelper.collections_test.set_test;

import org.junit.Test;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class SetTest {

    @Test
    public void linkedHashSetTest() {
        Set<String> strSet = new LinkedHashSet<>();
        strSet.add("456");
        strSet.add("123");
        System.out.println(strSet);
    }


    public static void main(String[] args) {

        Set<String> strSet = new HashSet<>();
        strSet.add("abc");
        System.out.println(strSet.add("def"));
        System.out.println(strSet.add("abc"));

        String[] strArr = new String[]{};
        strSet.toArray(strArr);
        System.out.println(strSet.toArray());

    }
}
