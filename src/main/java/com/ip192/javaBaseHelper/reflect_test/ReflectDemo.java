package com.ip192.javaBaseHelper.reflect_test;

import com.ip192.spring.accessToken.Login;
import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;

public class ReflectDemo {

    public void basicTry() throws ClassNotFoundException {
        Login login = new Login();
//        Arrays.asList(login.getClass().getMethods()).forEach(System.out::println);

        Arrays.asList(login.getClass().getFields()).forEach(field -> {
            System.out.println(field.getModifiers());
        });

        System.out.println(Login.class == Class.forName("com.ip192.spring.accessToken.Login"));

    }
    @Test
    public void testBasicTry() throws ClassNotFoundException {
        basicTry();
    }


    public void visitPrivateFieldTry() throws NoSuchFieldException, IllegalAccessException {
        Login login = new Login();

        Field field = Login.class.getDeclaredField("code");
        field.setAccessible(true);
        field.set(login, "success");
        System.out.println(login.getCode());
    }
    @Test
    public void testVisitPrivate() throws NoSuchFieldException, IllegalAccessException {
        visitPrivateFieldTry();
    }


    public void visitPrivateMethod() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Login login = new Login();

        Method method = Login.class.getDeclaredMethod("code", String.class);
        method.setAccessible(true);
        method.invoke(login, "Arguments");

        Method[] methods = Login.class.getDeclaredMethods();
        Arrays.asList(methods).forEach(m -> {
            if (Arrays.asList(m.getParameters()).size() > 0) {
                System.out.print(m.getName());

                System.out.println(Arrays.asList(m.getParameters()));
            }
        });
    }
    @Test
    public void testVisitPrivateMethod() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        visitPrivateMethod();
    }
}

