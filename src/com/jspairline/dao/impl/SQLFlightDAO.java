package com.jspairline.dao.impl;

import com.jspairline.dao.ConnectionPool;
import com.jspairline.dao.FlightDAO;
import com.jspairline.entity.Flight;
import java.sql.Connection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class SQLFlightDAO implements FlightDAO {

    private Connection jdbcConnection;

    public SQLFlightDAO() {}

    @Override
    public boolean insertFlight(Flight flight) throws SQLException {
        String sql = "INSERT INTO flights (src, dest, timestamp) VALUES (?, ?, ?)";
        jdbcConnection = ConnectionPool.connect();
        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setString(1, flight.getSrc());
        statement.setString(2, flight.getDest());
        statement.setString(3, flight.timestamp);
        boolean rowInserted = statement.executeUpdate() > 0;
        ConnectionPool.disconnect();
        return rowInserted;
    }

    @Override
    public List<Flight> listAllFlights() throws SQLException {
        List<Flight> listFlight = new ArrayList<>();
        String sql = "SELECT * FROM flights";

        jdbcConnection = ConnectionPool.connect();

        Statement statement = jdbcConnection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String title = resultSet.getString("src");
            String author = resultSet.getString("dest");
            String timestamp = resultSet.getString("timestamp");

            Flight book = new Flight(id, title, author, timestamp);
            listFlight.add(book);
        }

        resultSet.close();
        statement.close();

        ConnectionPool.disconnect();

        return listFlight;
    }
    @Override
    public boolean deleteFlight(Flight flight) throws SQLException {
        String sql = "DELETE FROM flights where id = ?";

        jdbcConnection = ConnectionPool.connect();

        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setInt(1, flight.getId());

        boolean rowDeleted = statement.executeUpdate() > 0;
        statement.close();
        ConnectionPool.disconnect();
        return rowDeleted;
    }
    @Override
    public boolean updateFlight(Flight flight) throws SQLException {
        String sql = "UPDATE flights SET src = ?, dest = ?, timestamp = ?";
        sql += " WHERE flight_id = ?";
        jdbcConnection = ConnectionPool.connect();

        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setString(1, flight.getSrc());
        statement.setString(2, flight.getDest());
        statement.setFloat(3, 123);
        statement.setInt(4, flight.getId());

        boolean rowUpdated = statement.executeUpdate() > 0;
        statement.close();
        ConnectionPool.disconnect();
        return rowUpdated;
    }
    @Override
    public Flight getFlight(int id) throws SQLException {
        Flight flight = null;
        String sql = "SELECT * FROM flights WHERE id = ?";

        jdbcConnection = ConnectionPool.connect();

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
