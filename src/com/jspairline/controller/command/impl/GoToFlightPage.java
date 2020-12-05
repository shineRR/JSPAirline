package com.jspairline.controller.command.impl;

import com.jspairline.controller.command.Command;
import com.jspairline.dao.impl.SQLFlightDAO;
import com.jspairline.entity.Flight;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class GoToFlightPage implements Command {
    private static final String MAIN_PAGE = "WEB-INF/jsp/main.jsp";
    private static final String SIGNIN_PAGE = "WEB-INF/jsp/signin.jsp";
    private static final String FLIGHT_PAGE = "WEB-INF/jsp/flightPage.jsp";

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession httpSession = request.getSession();
        Object role = httpSession.getAttribute("role");
        if (role != null)
            System.out.println(role.toString());
        RequestDispatcher requestDispatcher = request.getRequestDispatcher(FLIGHT_PAGE);
        SQLFlightDAO sqlFlightDAO = new SQLFlightDAO();
        List<Flight> listAllFlights = null;
        try {
            listAllFlights = sqlFlightDAO.listAllFlights();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        request.setAttribute("listFlight", listAllFlights);
        requestDispatcher.forward(request, response);
    }

}
