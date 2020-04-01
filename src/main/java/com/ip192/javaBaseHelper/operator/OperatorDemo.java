package com.ip192.javaBaseHelper.operator;

import org.junit.Test;

public class OperatorDemo {

    @Test
    public void addEqual() {

        byte b = 3;
        int i = 128;
        System.out.println((byte) i);
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


    // &
    @Test
    public void operatorOne() {
        int a = 10, // 1010 8+2
            b = 0, // 0
            c = 6; //  0110 4+2
        System.out.println(a & b);
        System.out.println(a & c);

        int d = 31, // 11111 16+8+4+2+1
            e = 25, // 11001 16+8+1
            f = 15; // 01111 8+4+2+1
        System.out.println(d & e); // 16+8+1
        System.out.println(d & f); // 8+4+2+1
        System.out.println(e & f); // 8+1
    }

    // |
    @Test
    public void operatorTwo() {

    }

    // ^
    @Test
    public void operatorThree() {

    }

    // ~
    @Test
    public void operatorFour() {
        int a = 65;
        byte b = -65;
        System.out.println(~a);
        System.out.println(Integer.toBinaryString(~a));
        System.out.println(~b);
    }

    // >> << >>>
    @Test
    public void operatorFive() {
        // << >>
        System.out.println(-12 >> 2);
        System.out.println(12 >> 2);
        System.out.println(-12 << 2);
        System.out.println(12 << 2);

        // >>>
        System.out.println(12 >>> 2);
        System.out.println(-12 >>> 2);

        System.out.println(-60 >> 9);
        System.out.println(60 >> 9);
        // [-128, -1]U[0, 127]
    }

}
