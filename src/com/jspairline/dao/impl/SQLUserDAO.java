package com.jspairline.dao.impl;

import com.jspairline.dao.UserDAO;
import com.jspairline.entity.User;
import com.jspairline.entity.UserData;

import java.sql.SQLException;

public class SQLUserDAO implements UserDAO {
    @Override
    public User authentification(String login, String password){

        try {
            throw new SQLException();
        }catch (SQLException e) {
//            throw new DaoException(e);
        }

        return null;
    }

    @Override
    public boolean registration(UserData userData) {
        try {
            throw new SQLException();
        }catch (SQLException e) {
//            throw new DaoException(e);
        }

        return false;
    }
}
