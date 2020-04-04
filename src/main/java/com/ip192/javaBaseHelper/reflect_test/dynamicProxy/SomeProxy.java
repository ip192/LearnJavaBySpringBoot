package com.ip192.javaBaseHelper.reflect_test.dynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

@SuppressWarnings("all")
public class SomeProxy<T> implements InvocationHandler {
    private T some;

    public T proxy(T t) {
        some = t;
        /**
         * 将被代理对象和代理类关联
         */
        return (T) Proxy.newProxyInstance(t.getClass().getClassLoader(), t.getClass().getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return method.invoke(some, args);
    }
}
