package com.ip192.javaBaseHelper.collections_test.set_test;

import java.util.HashSet;
import java.util.Set;

public class SetTest {
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
