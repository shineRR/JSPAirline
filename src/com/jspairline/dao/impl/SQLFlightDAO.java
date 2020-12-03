package com.jspairline.dao.impl;

import com.jspairline.dao.FlightDAO;
import com.jspairline.entity.Flight;
import com.mysql.jdbc.Connection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SQLFlightDAO implements FlightDAO {

    private String jdbcURL;
    private String jdbcUsername;
    private String jdbcPassword;
    private Connection jdbcConnection;

    public SQLFlightDAO(String jdbcURL, String jdbcUsername, String jdbcPassword) {
        this.jdbcURL = jdbcURL;
        this.jdbcUsername = jdbcUsername;
        this.jdbcPassword = jdbcPassword;
    }

    protected void connect() throws SQLException {
        if (jdbcConnection == null || jdbcConnection.isClosed()) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                throw new SQLException(e);
            }
            jdbcConnection = (Connection) DriverManager.getConnection(
                    jdbcURL, jdbcUsername, jdbcPassword);
        }
    }

    protected void disconnect() throws SQLException {
        if (jdbcConnection != null && !jdbcConnection.isClosed()) {
            jdbcConnection.close();
        }
    }

    @Override
    public boolean insertFlight(Flight flight) throws SQLException {
        String sql = "INSERT INTO PUBLIC.flight (id, srcCity, destCity, timestamp) VALUES (?, ?, ?)";
        connect();

        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setString(1, flight.getSrc());
        statement.setString(2, flight.getDest());
        statement.setString(3, flight.timestamp);

        boolean rowInserted = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        return rowInserted;
    }

    @Override
    public List<Flight> listAllFlights() throws SQLException {
        List<Flight> listFlight = new ArrayList<>();

        String sql = "SELECT * FROM flight";

        connect();

        Statement statement = jdbcConnection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String title = resultSet.getString("srcCity");
            String author = resultSet.getString("destCity");
            String timestamp = resultSet.getString("timestamp");

            Flight book = new Flight(id, title, author, timestamp);
            listFlight.add(book);
        }

        resultSet.close();
        statement.close();

        disconnect();

        return listFlight;
    }
    @Override
    public boolean deleteFlight(Flight flight) throws SQLException {
        String sql = "DELETE FROM flight where flight_id = ?";

        connect();

        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setInt(1, flight.getId());

        boolean rowDeleted = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        return rowDeleted;
    }
    @Override
    public boolean updateFlight(Flight flight) throws SQLException {
        String sql = "UPDATE flight SET src = ?, dest = ?, timestamp = ?";
        sql += " WHERE flight_id = ?";
        connect();

        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setString(1, flight.getSrc());
        statement.setString(2, flight.getDest());
        statement.setFloat(3, 123);
        statement.setInt(4, flight.getId());

        boolean rowUpdated = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        return rowUpdated;
    }
    @Override
    public Flight getFlight(int id) throws SQLException {
        Flight flight = null;
        String sql = "SELECT * FROM flight WHERE flight_id = ?";

        connect();

        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setInt(1, id);

        ResultSet resultSet = statement.executeQuery();

        if (resultSet.next()) {
            String title = resultSet.getString("srcCity");
            String author = resultSet.getString("destCity");
            String timestamp = resultSet.getString("timestamp");

            flight = new Flight(id, title, author, timestamp);
        }

        resultSet.close();
        statement.close();

        return flight;
    }
}
