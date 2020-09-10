package com.ip192.javaBaseHelper.map_test;

import com.alibaba.fastjson.JSONObject;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class MapDemo {
    /**
     * hashMap中key保存在数组中 数组容量每次*2 和hash算法有关
     */
    @Test
    public void setTest() {
        Map<Object, String> map = new HashMap<>();
        Object object1 = new Object();
        Object object2 = new Object();
        System.out.println(object1.hashCode() == object2.hashCode());
        map.put(object1, "1");
        map.put(object2, "2");
        System.out.println(map.keySet());
    }


    @Test
    public void getNoSet() {
        InnerObject innerObject = new InnerObject();
        innerObject.setParam(new HashMap<>());
        innerObject.getParam().put("key", "value");

        System.out.println(JSONObject.toJSONString(innerObject));
    }


    @Test
    public void tryAssert() {
        String str = "str";
        assert str.equals("");
    }
}

class InnerObject {
    private Map<String, Object> param;

    public Map<String, Object> getParam() {
        return param;
    }

    public void setParam(Map<String, Object> param) {
        this.param = param;
    }
}
