package com.ip192.javaBaseHelper.generics.inner;

import org.junit.Test;

public class InnerClassDemo {

    @Test
    public void innerClassTest() {
        OuterClass outerClass = new OuterClass();
//        OuterClass.InnerClass innerClass = outerClass.new InnerClass();
    }

}

class OuterClass {
    {
        System.out.println("OuterClass code block");
    }

    static {
        System.out.println("OuterClass static code block");
    }

    OuterClass() {
        System.out.println("OuterClass Constructor");
    }

    class InnerClass {
        {
            System.out.println("InnerClass code block");
        }

        InnerClass() {
            System.out.println("InnerClass Constructor");
        }
    }

    static class InnerClass2 {
        {
            System.out.println("InnerClass2 code block");
        }

        static {
            System.out.println("InnerClass2 static code block");
        }

        InnerClass2() {
            System.out.println("InnerClass2 Constructor");
        }
    }
}



/**
 * 同一个包下与GenericsDemo的非public类冲突
 */
//class Parent {}