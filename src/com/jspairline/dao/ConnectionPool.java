package com.jspairline.dao;

import java.sql.Connection;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionPool {
    private static String DATABASE_URL ="jdbc:mysql://localhost:3306/";
    private static String DATABASE_NAME = "flight";
    private static String DATABASE_USER_NAME = "root";
    private static String DATABASE_PASSWORD = "123456";
    private static String OPTIONS = "?serverTimezone=Europe/Minsk&allowMultiQueries=true";
    static Connection jdbcConnection;

    private static ConnectionPool instance;

    private ConnectionPool(){ }

    public static Connection connect() throws SQLException {
        if (jdbcConnection == null || jdbcConnection.isClosed()) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                throw new SQLException(e);
            }
            jdbcConnection = DriverManager.getConnection(
                    DATABASE_URL+ DATABASE_NAME + OPTIONS, DATABASE_USER_NAME, DATABASE_PASSWORD);
        }
        return jdbcConnection;
    }

    public static void disconnect() throws SQLException {
        if (jdbcConnection != null && !jdbcConnection.isClosed()) {
            jdbcConnection.close();
        }
    }
}
