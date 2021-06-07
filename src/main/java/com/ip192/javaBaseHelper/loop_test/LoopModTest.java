package com.ip192.javaBaseHelper.loop_test;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

// list loop modify test
public class LoopModTest {

    private List<String> strList;
    private List<LoopEntity> entityList;

    @Test
    public void addTest() {
        strList = Arrays.asList("hello", "world", "", "");

        for (String str : strList) {
            if (str.contains(strList.get(strList.size() - 1))) {
                // 在add()方法逻辑结束前 最后会检查modCount和expectedCount 然后抛出ConcurrentModificationException异常
//                strList.add("add");
                strList.set(2, "add");
                break;
            }
        }
        System.out.println(strList.size());

//        strList.iterator().remove();;
    }

    @Test
    public void modTest() {
        LoopEntity entity1 = new LoopEntity(10, "abc");
        LoopEntity entity2 = new LoopEntity(20, "def");
        LoopEntity entityDel = new LoopEntity();
        // asList()方法返回的是Arrays内部的ArrayList 会影响iterator的使用
//        entityList = Arrays.asList(entity1, entity2, entityDel);

        // 此方式生成的ArrayList可以正常操作iterator
        entityList = new ArrayList<>();
        entityList.add(entity1);
        entityList.add(entity2);
        entityList.add(entityDel);

        for (LoopEntity entity : entityList) {
            // 修改集合内部对象属性 允许
            entity.setAge(50);
        }
        Iterator<LoopEntity> iterator = entityList.iterator();
        while (iterator.hasNext()) {
            LoopEntity item = iterator.next();
            if (item.getName() == null) {
                iterator.remove();
            }
        }
        System.out.println(entityList);
    }

    @Test
    public void loopDependencyTest() {
        DependencyClassA classA = new DependencyClassA();
        classA.printA();
    }
}
