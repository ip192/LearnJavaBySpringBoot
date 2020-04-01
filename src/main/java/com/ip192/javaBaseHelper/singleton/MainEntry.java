package com.ip192.javaBaseHelper.singleton;

import org.junit.Test;

public class MainEntry {

    @Test
    public void test() {
        StaticInnerClassSingleton staticInnerClassSingleton1 = new StaticInnerClassSingleton().getInstance();
        StaticInnerClassSingleton staticInnerClassSingleton2 = new StaticInnerClassSingleton().getInstance();
        System.out.println(staticInnerClassSingleton1 == staticInnerClassSingleton2);
    }
}
