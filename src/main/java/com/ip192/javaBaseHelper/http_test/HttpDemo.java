package com.ip192.javaBaseHelper.http_test;

import org.junit.Test;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class HttpDemo {

    public void post() throws IOException {
        String add_url = "http://localhost:7070/api/team-job/create";
        URL url = new URL(add_url);
        HttpURLConnection connection = (HttpURLConnection)url.openConnection();
        connection.setRequestProperty("Content-Type", "application/json");
        connection.setRequestMethod("POST");
        connection.setDoInput(true);
        connection.setDoOutput(true);
        connection.connect();
        DataOutputStream out = new DataOutputStream(connection.getOutputStream());

        out.writeBytes("jobs:wp");
        out.flush();
        out.close();
    }
    @Test
    public void testPost() throws IOException {
        post();
    }

}


class TeamJob {
    /**
     * 问诊处理
     */
    public static final Integer CONSULTATION = 1;
    /**
     * 群发消息
     */
    public static final Integer MESSAGES = 2;
    /**
     * 客服服务
     */
    public static final Integer CUSTOMS = 3;

    /**
     * 开关状态-显示
     */
    public static final Integer YES = 1;

    /**
     * 开关状态-隐藏
     */
    public static final Integer NO = 2;

    private Long id;

    /**
     * 工作分配类别
     * 问诊处理/群发消息/客服服务
     */
    private String jobType;

    /**
     * 对应团队id
     */
    private Long teamId;

    /**
     * 团队医生id
     */
    private Long doctorId;

    /**
     * 群组id
     */
    private Long groupId;

    /**
     * 群聊id
     */
    private Long groupChatId;

    /**
     * 开关状态位
     */
    private Integer display;

    /**
     * 创建时间
     */
//    private Date createTime;

    /**
     * 创建人
     */
//    private Long createUser;

    /**
     * 更新时间
     */
//    private Date updateTime;

    /**
     * 更新人
     */
//    private Long updateUser;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getJobType() {
        return jobType;
    }

    public void setJobType(String jobType) {
        this.jobType = jobType;
    }

    public Long getTeamId() {
        return teamId;
    }

    public void setTeamId(Long teamId) {
        this.teamId = teamId;
    }

    public Long getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Long doctorId) {
        this.doctorId = doctorId;
    }

    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    public Long getGroupChatId() {
        return groupChatId;
    }

    public void setGroupChatId(Long groupChatId) {
        this.groupChatId = groupChatId;
    }

//    public Date getCreateTime() {
//        return createTime;
//    }
//
//    public void setCreateTime(Date createTime) {
//        this.createTime = createTime;
//    }
//
//    public Long getCreateUser() {
//        return createUser;
//    }
//
//    public void setCreateUser(Long createUser) {
//        this.createUser = createUser;
//    }
//
//    public Date getUpdateTime() {
//        return updateTime;
//    }

//    public void setUpdateTime(Date updateTime) {
//        this.updateTime = updateTime;
//    }

//    public Long getUpdateUser() {
//        return updateUser;
//    }
//
//    public void setUpdateUser(Long updateUser) {
//        this.updateUser = updateUser;
//    }

    public Integer getDisplay() {
        return display;
    }

    public void setDisplay(Integer display) {
        this.display = display;
    }
}
