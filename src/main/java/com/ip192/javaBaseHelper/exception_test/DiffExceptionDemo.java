package com.ip192.javaBaseHelper.exception_test;

import java.io.IOException;

public class DiffExceptionDemo {

    public static void main(String[] args) {
        MyException myException = new MyException();
        String str = "";
        try {
            str = myException.getStr();
        } catch (IOException ie) {
            System.out.println("io exception msg: " + ie.getMessage());
        } catch (RuntimeException re) {
            System.out.println("runtime exception msg: " + re.getMessage());
        }
        System.out.println("str" + str);
    }

}

class MyException {
    public String getStr() throws IOException {
        if (true) {
            throw new RuntimeException("failed");
        }
        return "ok";
    }
}