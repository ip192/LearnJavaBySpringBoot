package com.ip192.javaBaseHelper.collections_test.linked_list;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

public class LinkedListDemo {
    /**
     * 基本方法都是围绕着内部Node进行的
     * node.prev node.item node.next 对前后指针进行修改
     * 其中node(index)方法负责找到制定位置的node对象
     */

    @Test
    public void simpleTest() {
        List list = new LinkedList();
        list.iterator();
        list.listIterator(4);
    }

    /**
     * linkedList有正序和倒叙两种迭代器
     */

    /**
     * iterator迭代器可在List Set Map中使用 方法较少
     * list iterator只能在List中使用 方法较多
     */
}
