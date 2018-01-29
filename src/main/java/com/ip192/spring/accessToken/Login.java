package com.ip192.spring.accessToken;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "accesstokens")
public class Login {
    @Id
    public String _id;

    public String code;
    public String token;
    public Date endTime;
    public String content;

    public String serviceId;
    public String serviceType;
    public int status;
    public long expiresIn;
    public Date lastAt;
}
