package com.ip192.javaBaseHelper.list_test;

import org.junit.Test;

public class ArrayTest {

    @Test
    public void arrayTest() {
        int a[] = {1, 2, 3, 4};
        int b[] = a;
        b[0] = 0;
        System.out.println(a[0]);
    }

    @Test
    public void newArray() {
        Object[] obj1 = {1};
        Object[] obj2 = new Object[]{1};
        System.out.println(obj1[0] == obj2[0]);
    }
}
