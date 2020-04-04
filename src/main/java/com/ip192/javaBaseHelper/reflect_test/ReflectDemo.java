package com.ip192.javaBaseHelper.reflect_test;

import com.ip192.spring.accessToken.Login;
import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;

/**
 * 从Class开始，获得类信息，属性信息，方法信息等
 */
public class ReflectDemo {

    public void visitPublicFields() throws ClassNotFoundException {
        Login login = new Login();
        login.set_id("1010");
//        Arrays.asList(login.getClass().getMethods()).forEach(System.out::println);

        Arrays.asList(login.getClass().getFields()).forEach(field -> {
            try {
                System.out.println(field.get(login));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            // 修饰符常量对应Modifier.PUBLIC......
            System.out.println(field.getModifiers());
        });

        System.out.println(Login.class == Class.forName("com.ip192.spring.accessToken.Login"));
        System.out.println(Login.class == login.getClass());
    }
    @Test
    public void testVisitPublicFields() throws ClassNotFoundException {
        visitPublicFields();
    }


    public void visitPrivateFields() throws NoSuchFieldException, IllegalAccessException {
        Login login = new Login();

        Field field = Login.class.getDeclaredField("code");
        field.setAccessible(true);
        field.set(login, "success");
        System.out.println(login.getCode());
    }
    @Test
    public void testVisitPrivateFields() throws NoSuchFieldException, IllegalAccessException {
        visitPrivateFields();
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


    @Test
    public void classTest() {
        System.out.println(Object.class == new Object().getClass());
    }
}

