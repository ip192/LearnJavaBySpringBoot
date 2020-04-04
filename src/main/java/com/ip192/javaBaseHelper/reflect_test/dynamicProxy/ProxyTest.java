package com.ip192.javaBaseHelper.reflect_test.dynamicProxy;

import org.junit.Test;

public class ProxyTest {

    @Test
    public void dynamicProxyTest() {
        // 创建一个InvocationHandler实例
        SomeProxy<SomeInterface> someProxy = new SomeProxy<>();
        // 将被代理对象与对应动态代理对象绑定
        SomeInterface someSubject = someProxy.proxy(new SomeSubject());
        // 被代理后执行方法，都去调用invoke去动态执行
        someSubject.someMethod();
        SomeInterface otherSubject = someProxy.proxy(new OtherSubject());
        otherSubject.someMethod();
    }
}
