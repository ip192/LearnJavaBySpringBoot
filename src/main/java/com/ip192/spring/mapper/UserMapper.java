package com.ip192.spring.mapper;

import com.ip192.spring.entity.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {

    Integer insertOne(User user);


}
