package com.ip192.javaBaseHelper.collections_test.array_test;

import org.junit.Test;

import java.util.*;

public class ArrayListDemo {

    /**
     * new ArrayList<>() 返回的是可变的集合
     * Arrays.asList() 返回的是一个原数组的变形(引用)
     */
    public void arrayToArrayList() {
        DemoEntity[] demoEntityArray = {new DemoEntity(), new DemoEntity(), new DemoEntity()};

        ArrayList<DemoEntity> al = new ArrayList<>(Arrays.asList(demoEntityArray));
        al.add(new DemoEntity());
        System.out.println(al.size());

        List l = Arrays.asList(demoEntityArray);
        // l.add(new DemoEntity()); 数组越界
        demoEntityArray[2] = null;
        System.out.println(l.get(2));

        System.out.println(al.get(2) instanceof DemoEntity);
    }
    @Test
    public void testArrayToArrayList() {
        arrayToArrayList();
    }


    /**
     * 1.ArrayList借助内部维护的 Object数组存储数据
     *
     * 2.实现了RandomAccess接口 表示此集合结构内维护着数组或其它可进行遍历优化的结构(使用for循环get下标) LinkedList此类链表结构遍历就不会具备可优化标志
     *
     * 3.数组满了后扩容为 old + old >> 1   1.5 * old
     */

    /**
     * 初始容量是10 和一个空数组
     * add一个元素 根据数组长度和size值判断是否需要扩容 第一次add 数组变成除第一个元素外其余都为null
     * 当数组满了继续add 数组扩容为15 每次add size属性自增
     */
    @Test
    public void addCapacityTest() {
        List<Integer> intList = new ArrayList<>();
        for (int i = 0; i < 15; i ++) {
            /**
             * 跳过前10次add后 内部数组已扩容
             * 此时在ArrayList add中加断点 可以将鼠标放置elementData上 看到长度为15
             */
            intList.add(i);
            if (i == 11) {
                System.out.println(intList);
            }
        }
    }

    /**
     * indexOf方法会遍历数组 将匹配到的第一个 数组下标返回
     * 对于null的查找用== 非null使用.equals
     */

    /**
     * remove方法 是将数组index位置之后的 拷贝到index到size-1
     * 将--size的元素设为null
     */

    /**
     * add和remove方法会使modCount自增
     * 各个实现了iterator接口的类 因数据结构不同 迭代方式不同
     * 内部Iterator的实现中 会在创建时将modCount记录为内部变量expectedModCount
     * 所以迭代器创建了 再对arrayList add/remove 迭代器会在使用中抛异常
     */

}
