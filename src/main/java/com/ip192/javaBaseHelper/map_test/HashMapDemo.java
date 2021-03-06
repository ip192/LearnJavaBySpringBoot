package com.ip192.javaBaseHelper.map_test;

import org.junit.Test;
import org.omg.CORBA.MARSHAL;

import java.util.*;

public class HashMapDemo {
    private Map<Integer, String> map = new HashMap<Integer, String>(){
        {
            put(1, "one");
            put(2, "two");
            put(3, "three");
            put(4, "four");
        }
    };

    @Test
    public void testCreateTry() {
        System.out.println(map.put(null, "null"));
        System.out.println(map);
        System.out.println(map.put(null, null));
        System.out.println(map);
    }


    @Test
    public void testGetContainsTry() {
        System.out.println(map.get(1));
        System.out.println(map.get(11));

        System.out.println(map.containsKey(1));
        // containsValue()使用equals()比较
        System.out.println(map.containsValue("one"));
        System.out.println(map.containsValue("on"));
    }


    @Test
    public void testValuesTry() {
//        ArrayList<String> valList = (ArrayList<String>) map.values();
//        String[] strings = (String[]) map.values().toArray();
//        System.out.println(valList);
//        System.out.println(strings);
        System.out.println(map.values());
    }


    public void putRemoveTry() {
//        System.out.println(map.put(4, "five"));
//        System.out.println(map);
//        System.out.println(map.replace(4,"four"));
//        System.out.println(map);
//        System.out.println(map.replace(5, "five"));
//        System.out.println(map);


        System.out.println(map.remove(4));
        System.out.println(map.remove(5));
        System.out.println(map);
        System.out.println(map.remove(4, "four"));
        System.out.println(map.remove(3, "three"));
        System.out.println(map);
    }
    @Test
    public void testPutRemoveTry() {
        putRemoveTry();
    }


    public void ketSetStreamTry() {
        System.out.println(map.keySet());
        System.out.println(map.entrySet());
        System.out.println(map.values());

        Iterator iterator = map.entrySet().iterator();
        System.out.println(iterator.next());
        System.out.println(iterator.next());

        map.forEach((key, value) -> System.out.println(key + ": " + value));
    }
    @Test
    public void testKeySetStreamTry() {
        ketSetStreamTry();
    }


    public void mapArrayTry() {
        ArrayList al = new ArrayList<>(Arrays.asList(1, 2));
        ArrayList<Integer> bl = new ArrayList<>(Arrays.asList(1, 2));
        ArrayList cl = new ArrayList<>(Arrays.asList(1, 2));
        ArrayList dl = new ArrayList<>(Arrays.asList(1, 2));
        Map<String, ArrayList> map = new HashMap<>();
        map.put("al", al);
        map.put("bl", bl);
        map.put("cl", cl);
        map.put("dl", dl);
        System.out.println(map);
        bl.add(3);
        System.out.println(map);
    }
    @Test
    public void testMapArrayTry() {
        mapArrayTry();
    }

}
