package com.ip192.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan(basePackages = "com.ip192.spring")
public class Entrance {
    public static void main(String[] args) {
        SpringApplication.run(Entrance.class, args);
    }
}
