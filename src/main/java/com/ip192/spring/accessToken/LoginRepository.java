package com.ip192.spring.accessToken;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LoginRepository extends MongoRepository<Login, String> {
    @Query("{}")
    List<Login> getAll();


}
