package com.disquera.controllers.models;

public class UserModelVO {

    private String id;
    private String user;
    private String password;
    private String rol;
    private String status;

    public UserModelVO(String id, String user, String password, String rol, String status) {
        this.id = id;
        this.user = user;
        this.password = password;
        this.rol = rol;
        this.status = status;
    }

    public UserModelVO(String user, String password) {
        this.user = user;
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
