package com.example.SpringBootDemo.spring.service;

import com.ip192.spring.entity.User;
import com.ip192.spring.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
public class TransactionalTest {
    @Autowired
    private UserMapper userMapper;


    @Test
    public void insertTest() {
        User user = new User();
        user.setAge(10);
        user.setName("one");
        userMapper.insertOne(user);
    }
}
