package com.ip192.javaBaseHelper.base_type_test;

import org.junit.Test;

public class IntegerTest {

    public static void main(String[] args) {
        // 相当于执行了 Integer.valueOf(129)
        Integer a = 129;
        new IntegerTest().change(a);
        System.out.println(a);

    }

    void change(Integer i) {
        // 相当于执行了i.intValue();
        i += 1;
    }

    @Test
    public void test() {
        Integer a = new Integer("44.44");
        System.out.println(a);
    }

    @Test
    public void equalsTest() {
        Integer a = 10;
        Long b = 10L;
        Double c = 10.0;
        System.out.println(a.equals(b));
        System.out.println(c.equals(b));
    }

    @Test
    public void ruleTest() {
        BoolTest a[] = {new BoolTest(), new BoolTest()};
        BoolTest b[] = a;
        b = null;
        System.out.println(a[0]);
        System.out.println(b);
//        new Object().hashCode();

//        int a = 3;
//        System.out.println(a++ > 3 ? (a == 3 ? 10 : 11) : (a == 4 ? 12 : 13));
    }
}
