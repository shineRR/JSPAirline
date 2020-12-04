package com.jspairline.entity;

import java.io.Serializable;
import java.util.Objects;

public class UserData implements Serializable  {

    private int id;
    private String login;
    private String role;
    private String surname;
    private String email;
    private String password;

    public UserData() {}

    public UserData(int id, String login, String role,String password) {
        this.id = id;
        this.login = login;
        this.role = role;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String email) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserData userData = (UserData) o;
        return id == userData.id &&
                Objects.equals(login, userData.login) &&
                Objects.equals(role, userData.role) &&
                Objects.equals(password, userData.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, login, role, password);
    }

    @Override
    public String toString() {
        return "UserData[id=" + id +
                ", login='" + login + '\'' +
                ", name='" + role + '\'' +
                ", password='" + password + '\'' +
                ']';
    }
}
