package com.ip192.spring.service.transactionals;

import com.ip192.spring.entity.User;
import com.ip192.spring.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TransactionInvokeTwoService {
    @Autowired
    private UserMapper userMapper;

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void invokeTwo() {
        User user = new User();
        user.setAge(20);
        user.setName("two");
        userMapper.insertOne(user);

        int i = 1 / 0;
    }

}
