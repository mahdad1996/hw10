package com.HW08.maktab32.entities;

public class UserInfo {
    String username;
    String natinalCode;

    public UserInfo(String username, String natinalCode) {
        this.username = username;
        this.natinalCode = natinalCode;
    }

    public UserInfo() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNatinalCode() {
        return natinalCode;
    }

    public void setNatinalCode(String natinalCode) {
        this.natinalCode = natinalCode;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "username='" + username + '\'' +
                ", natinalCode='" + natinalCode + '\'' +
                '}';
    }
}
