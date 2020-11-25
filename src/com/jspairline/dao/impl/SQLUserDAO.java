package com.jspairline.dao.impl;

import com.jspairline.dao.UserDAO;
import com.jspairline.entity.User;
import com.jspairline.entity.UserData;

import java.sql.SQLException;

public class SQLUserDAO implements UserDAO {
    @Override
    public User authentification(String login, String password) throws SQLException {


        return null;
    }

    @Override
    public boolean registration(UserData userData) throws SQLException {


        return false;
    }
}
