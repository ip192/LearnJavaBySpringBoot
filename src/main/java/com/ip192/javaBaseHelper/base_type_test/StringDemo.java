package com.ip192.javaBaseHelper.base_type_test;

import org.apache.tomcat.util.buf.StringUtils;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

public class StringDemo {

    public void stringEqual() {
//        String a = "string one";
//        String b = "string" + " " + "one";
//        System.out.println(a.equals(b));

//        System.out.println("|\t|");
//        System.out.println("|  |");
//        System.out.println("\t".equals("  "));
//        System.out.println("\t" == "  ");

        String s = new String("abc");
        change(s);
        System.out.println(s);
    }
    @Test
    public void testStringEqual() {
        stringEqual();
    }

    void change(String s) {
        s += " end";
    }

    @Test
    public void convert() {
        String strArr[] = {"ab", "cd", "", "ef"};
        System.out.println(Arrays.toString(strArr));
        System.out.println(StringUtils.join(strArr));
        Iterator iterator = ((Collection)Arrays.asList(strArr)).iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

}
