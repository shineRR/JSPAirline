package com.jspairline.dao;

import com.jspairline.entity.User;
import com.jspairline.entity.UserData;

import java.sql.SQLException;

public interface UserDAO {
    User authentification (String login, String password) throws SQLException;

    boolean registration (UserData userData) throws SQLException;
}
