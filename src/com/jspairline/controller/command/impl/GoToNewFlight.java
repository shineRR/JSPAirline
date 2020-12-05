package com.jspairline.controller.command.impl;

import com.jspairline.controller.command.Command;
import com.jspairline.dao.impl.SQLFlightDAO;
import com.jspairline.entity.Flight;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

public class GoToNewFlight extends HttpServlet implements Command {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String srcCity = request.getParameter("src");
        String destCity = request.getParameter("dest");
        String timestamp = request.getParameter("timestamp");
        SQLFlightDAO sqlFlightDAO = new SQLFlightDAO();
        Flight flight = new Flight(0, srcCity, destCity, timestamp);
        boolean result = false;
        try {
            result = sqlFlightDAO.insertFlight(flight);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        HttpSession httpSession = request.getSession();
        if (!result)
        {
            httpSession.invalidate();
            request.setAttribute("error", "Invalid Form!");
        }
    }

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getMethod().equalsIgnoreCase("POST"))
            doPost(request, response);
        String page = "/WEB-INF/jsp/flightForm.jsp";
        RequestDispatcher requestDispatcher = request.getRequestDispatcher(page);
        requestDispatcher.forward(request, response);
    }
}
