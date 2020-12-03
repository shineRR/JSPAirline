package com.jspairline.dao.impl;

import com.jspairline.dao.ConnectionPool;
import com.jspairline.dao.UserDAO;
import com.jspairline.entity.Flight;
import com.jspairline.entity.User;
import com.jspairline.entity.UserData;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SQLUserDAO implements UserDAO {
    Connection jdbcConnection;

    public SQLUserDAO() {}

    public UserData userDataSelect(String login) throws SQLException {
        UserData userData = null;
        String sql = "SELECT * FROM users WHERE login = ?";
        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setString(1, login);

        ResultSet resultSet = statement.executeQuery();

        if (resultSet.next()) {
            int id = resultSet.getInt("id");
            String userLogin = resultSet.getString("login");
            String password = resultSet.getString("password");

            userData = new UserData(id, userLogin, "", "", "", password);
        }
        return userData;
    }

    public boolean userDataInsert(UserData userData) throws SQLException {
        String sql = "INSERT INTO users (login, password) VALUES (?, ?)";
        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setString(1, userData.getLogin());
        statement.setString(2, userData.getPassword());
        return statement.executeUpdate() > 0;
    }

    @Override
    public User authentification(String login, String password) throws SQLException {
        jdbcConnection = ConnectionPool.connect();
        UserData userData = userDataSelect(login);
        User user = null;
        if (userData != null && password.equalsIgnoreCase(userData.getPassword())) {
            user = new User(userData.getId(), userData.getLogin(), userData.getName(), userData.getSurname(), userData.getEmail());
        }
        ConnectionPool.disconnect();
        return user;
    }

    @Override
    public boolean registration(UserData userData) throws SQLException {
        boolean state = false;
        jdbcConnection = ConnectionPool.connect();
        UserData userDataFromDB = userDataSelect(userData.getLogin());
        if (userDataFromDB == null)
            state = userDataInsert(userData);
        ConnectionPool.disconnect();
        return false;
    }
}
