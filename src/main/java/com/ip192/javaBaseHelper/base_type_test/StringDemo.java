package com.ip192.javaBaseHelper.base_type_test;

import org.apache.tomcat.util.buf.StringUtils;
import org.junit.Test;

import java.nio.charset.StandardCharsets;
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

    @Test
    public void StringAddressTest() {
        // 通过debug发现str3与str4
        String str1 = "abcd";
        String str2 = "efgh";
        String str3 = (str1 + str2).intern();
        String str4 = "abcdefgh";
    }

    @Test
    public void StringCharacter() {
        /**
         * String的字符变换
         */
        String str = "abcdefg";
        String newStr = new String(str.getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);
    }

    @Test
    public void hashCodeTest() {
        /**
         * hashCode是int类型，可能丢失精度，导致超范围的不同的部分丢失
         */
        String str = "ABCDEa123abc";
        String str2 = "ABCDFB123abc";
        int strCode = str.hashCode();
        int strCode2 = str2.hashCode();
        System.out.println(strCode == strCode2);
    }
}
