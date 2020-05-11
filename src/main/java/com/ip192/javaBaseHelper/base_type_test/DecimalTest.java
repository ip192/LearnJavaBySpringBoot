package com.ip192.javaBaseHelper.base_type_test;

import java.math.BigDecimal;

public class DecimalTest {

    public static void main(String[] args) {
        String num = "3.33";
        Double d = new Double(num);
        Float f = new Float(num);
        BigDecimal bd1 = new BigDecimal(num);
        BigDecimal bd2 = new BigDecimal(num);
//        System.out.println(d.floatValue() == f.floatValue());
//        System.out.println(Math.abs(d - f) == 0);

//        System.out.println(d.compareTo(f.doubleValue()));
//        System.out.println(f.compareTo(d.floatValue()));

        System.out.println(bd1.toBigInteger());
    }
}
