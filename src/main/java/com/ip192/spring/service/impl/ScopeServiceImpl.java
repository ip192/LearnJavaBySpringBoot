package com.ip192.spring.service.impl;

import com.ip192.spring.service.ScopeService;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

//@Scope("prototype")
@Service
public class ScopeServiceImpl implements ScopeService {
    private Integer count = 0;

    @Override
    public void scopeTry() {
        this.count++;
        System.out.println("service count: " + this.count);
    }
}
