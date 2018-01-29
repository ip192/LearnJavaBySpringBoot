package com.ip192.spring.accessToken;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoginService {
    @Autowired
    private LoginRepository loginRepository;

    public List<Login> getAll() {
        return loginRepository.getAll();
    }
}
