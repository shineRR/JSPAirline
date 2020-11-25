package com.jspairline.dao;

import com.jspairline.entity.Flight;

import java.sql.SQLException;
import java.util.List;

public interface FlightDAO {
    boolean insertFlight(Flight flight) throws SQLException;
    List<Flight> listAllFlights() throws SQLException;
    boolean deleteFlight(Flight flight) throws SQLException;
    boolean updateFlight(Flight flight) throws SQLException;
    Flight getFlight(int id) throws SQLException;
}
