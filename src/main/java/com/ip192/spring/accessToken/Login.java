package com.ip192.spring.accessToken;


import java.util.Date;

public class Login {

    public String _id;

    private String code;
    private String token;
    private Date endTime;
    private String content;

    private String serviceId;
    private String serviceType;
    private int status;
    private long expiresIn;
    private Date lastAt;


    private void code(String args) {
        System.out.println(args);
    }
    private void code(String str, Integer index, Date date) {
        System.out.print(str);
        System.out.print(index);
        System.out.print(date);
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getServiceId() {
        return serviceId;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public long getExpiresIn() {
        return expiresIn;
    }

    public void setExpiresIn(long expiresIn) {
        this.expiresIn = expiresIn;
    }

    public Date getLastAt() {
        return lastAt;
    }

    public void setLastAt(Date lastAt) {
        this.lastAt = lastAt;
    }
}
