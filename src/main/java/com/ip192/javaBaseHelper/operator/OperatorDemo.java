package com.ip192.javaBaseHelper.operator;

import org.junit.Test;

public class OperatorDemo {

    public void addEqual() {

        byte b = 3;
        int i = 128;
        b += i; // b = b + i; // 异常
        System.out.println(b);
        byte bb = 3 + (byte)128;
        System.out.println(bb);

        byte bbb = (byte) (3 + (byte)128 + (byte)128);
        System.out.println(bbb);
        bbb = 3;
        bbb += 128;
        bbb += 128;
        System.out.println(bbb);
    }
    @Test
    public void testAddEqual() {
        addEqual();
    }
}
