package com.jspairline.controller.command.impl;

import com.jspairline.controller.command.Command;
import com.jspairline.dao.impl.SQLFlightDAO;
import com.jspairline.entity.Flight;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class GoToNewFlight implements Command {

    private void insertBook(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        String src = request.getParameter("src");
        String dest = request.getParameter("dest");
        String timestamp = request.getParameter("timestamp");

        SQLFlightDAO sqlFlightDAO = new SQLFlightDAO("jdbc:mysql://localhost:8080/mysqljdbc", "root", "");

        Flight newFlight = new Flight(1, src, dest, timestamp);
        sqlFlightDAO.insertFlight(newFlight);
        response.sendRedirect("list");
    }

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String page = "/WEB-INF/jsp/flightForm.jsp";
        RequestDispatcher requestDispatcher = request.getRequestDispatcher(page);
        requestDispatcher.forward(request, response);
    }
}
