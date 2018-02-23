package com.ip192.javaBaseHelper.box.unbox;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

public class BoxDemo {

    public void ps() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Parent parent = new Parent();
        parent.say();
        System.out.println(parent.getClass());

        Parent son = new Son();
        son.say();
        System.out.println(son.getClass());
        // son.doo(); // 无法直接调用
        Method method = son.getClass().getDeclaredMethod("doo");
        method.invoke(son);
    }
    @Test
    public void testPs() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        ps();
    }



    public void tryNew() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Parent parent = Parent.class.getDeclaredConstructor().newInstance();
        parent.say();

        Parent pson = Son.class.getDeclaredConstructor().newInstance();
        pson.say();

        Son son = Son.class.getDeclaredConstructor().newInstance();
        System.out.println(pson.getClass() == son.getClass());
    }
    @Test
    public void testTryNew() throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        tryNew();
    }



    public void tryConstructor() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Parent parent = Parent.class.getDeclaredConstructor(new Class[]{String.class}).newInstance("second constructor");
        parent.say();

        Constructor[] constructors = Parent.class.getDeclaredConstructors();
        Arrays.asList(constructors).forEach(c -> {
            System.out.println(c.getName());
            Arrays.asList(c.getParameterTypes()).forEach(System.out::println);
        });
    }
    @Test
    public void testTryConstructor() throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        tryConstructor();
    }



    public void tryAnnotation() {
        Arrays.asList(Parent.class.getAnnotations()).forEach(System.out::println);
    }
    @Test
    public void testTryAnnotation() {
        tryAnnotation();
    }
}


//@RequestMapping
//@Service
class Parent {
//    private Parent() {}
    Parent() {}
    Parent(String out) {
        System.out.println(out);
    }

//    @Autowired
    protected void say() {
        System.out.println("parent say");
    }
}

class Son extends Parent {
//    Son() {
//        super("");
//        say();
//    }
    protected void say() {
        System.out.println("son say");
    }
    protected void doo() {
        System.out.println("son do");
    }
}
