package com.jspairline.dao;

import com.mysql.jdbc.Connection;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionPool {
    private String DATABASE_URL ="jdbc:mysql://localhost:8080/";
    private String DATABASE_NAME = "flight";
    private String DATABASE_USER_NAME = "user";
    private String DATABASE_PASSWORD = "12345";
    private String OPTIONS = "?serverTimezone=Europe/Minsk&allowMultiQueries=true"; //useUnicode=true&characterEncoding=UTF8&

    private static ConnectionPool instance;

    private ConnectionPool(){ }

    public static ConnectionPool getInstance() {
        if(instance == null) {
            instance = new ConnectionPool();
            try {
                Class.forName("com.mysql.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        return instance;
    }

    public Connection connect() {
        Context ctx;
        Connection connection = null;
        try {
            ctx = new InitialContext();
            connection = (Connection) DriverManager.getConnection(DATABASE_URL+ DATABASE_NAME + OPTIONS,DATABASE_USER_NAME,DATABASE_PASSWORD);
        } catch (NamingException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
