package com.example.weatherapivolley;

public class ResponseModel {


        private String status;
        private String msg;
        private int id;
        private String username;
        private int roles;
        private String currentTimeStamp;
        private String tokenType;
        private String accessToken;

        // Getter and Setter methods here


    public ResponseModel(String status, String msg, int id, String username, int roles, String currentTimeStamp, String tokenType, String accessToken) {
        this.status = status;
        this.msg = msg;
        this.id = id;
        this.username = username;
        this.roles = roles;
        this.currentTimeStamp = currentTimeStamp;
        this.tokenType = tokenType;
        this.accessToken = accessToken;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getRoles() {
        return roles;
    }

    public void setRoles(int roles) {
        this.roles = roles;
    }

    public String getCurrentTimeStamp() {
        return currentTimeStamp;
    }

    public void setCurrentTimeStamp(String currentTimeStamp) {
        this.currentTimeStamp = currentTimeStamp;
    }

    public String getTokenType() {
        return tokenType;
    }

    public void setTokenType(String tokenType) {
        this.tokenType = tokenType;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }
}



