package com.ip192.javaBaseHelper.base_type_test;

import org.junit.Test;

import java.math.BigDecimal;

public class DecimalTest {
    @Test
    public void decimalMethod() {
        String num = "3.33";
        BigDecimal bd1 = new BigDecimal(num);
        BigDecimal bd2 = new BigDecimal(num);
        BigDecimal bd3 = new BigDecimal("0.3");

        System.out.println(bd1.toBigInteger());
        System.out.println(bd1.equals(bd2));

    }


    @Test
    public void floatDoubleCompare() {
        String num = "3.33";
        Double d = new Double(num);
        Float f = new Float(num);
        System.out.println(d.floatValue() == f); // true
        System.out.println(Math.abs(d - f));

//        System.out.println(f.compareTo(d.floatValue())); // true
//        System.out.println(d.compareTo(f.doubleValue())); // false
    }
}
