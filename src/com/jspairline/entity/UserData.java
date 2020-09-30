package com.jspairline.entity;

import java.io.Serializable;
import java.util.Objects;

public class UserData implements Serializable  {

    private int id;
    private String login;
    private String name;
    private String surname;
    private String email;
    private String password;

    public UserData() {}

    public UserData(int id, String login, String name, String surname, String email, String password) {
        this.id = id;
        this.login = login;
        this.name = name;
        this.surname = surname;
        this.email = email;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
                Objects.equals(name, userData.name) &&
                Objects.equals(surname, userData.surname) &&
                Objects.equals(email, userData.email) &&
                Objects.equals(password, userData.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, login, name, surname, email, password);
    }

    @Override
    public String toString() {
        return "UserData[id=" + id +
                ", login='" + login + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ']';
    }
}
