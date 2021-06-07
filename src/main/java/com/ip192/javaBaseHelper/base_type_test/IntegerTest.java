package com.ip192.javaBaseHelper.base_type_test;

import org.junit.Test;

public class IntegerTest {

    void change(Integer i) {
        // 相当于执行了i.intValue();
        i += 1;
    }
    @Test
    public void changeTest() {
        // 相当于执行了 Integer.valueOf(129)
        Integer a = 129;
        new IntegerTest().change(a);
        System.out.println(a);

        System.out.println((1 << Integer.SIZE - 3) - 1);
    }

    /**
     * 连续操作
     */
    @Test
    public void multiOperate() {
//        Integer a = new Integer("44.44");
//        System.out.println(a);

        int i = 2;
        System.out.println(i++); // 2
        int j = i++; // 下一行才开始生效
        j = i++;
        System.out.println(j); // 4

        // 与操作符优先级无关，从右向左运算，i的值只取一次期间不变
        int m = 3;
        System.out.println(m *= m -= m += m); // -9

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

    @Test
    public void typeTest() {
        Integer a = 127;
        Integer b = 127;
        System.out.println(a.equals(b));
        System.out.println(a == b);
    }

    @Test
    public void intToBinary() {
        int i = 254;
        System.out.println(Integer.toBinaryString(i));
    }

    @Test
    public void doubleTest() {
        double a = 0;
        double b = 0d;
        System.out.println(Double.compare(a, b));
        System.out.println(Double.valueOf("0.00") == 0);
    }
}
