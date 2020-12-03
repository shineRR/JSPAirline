package com.jspairline.controller.command.impl;

import com.jspairline.controller.command.Command;
import com.jspairline.dao.ConnectionPool;
import com.jspairline.dao.impl.SQLFlightDAO;
import com.jspairline.entity.Flight;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
        import javax.servlet.http.HttpServletRequest;
        import javax.servlet.http.HttpServletResponse;
        import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class GoToSignInCommand implements Command {

    private static final String MAIN_PAGE = "WEB-INF/jsp/main.jsp";
    private static final String SIGNIN_PAGE = "WEB-INF/jsp/signin.jsp";
    private static final String SIGHUP_PAGE = "WEB-INF/jsp/signup.jsp";

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        SQLFlightDAO sqlFlightDAO = new SQLFlightDAO();
        Flight flight = new Flight(1, "old", "new", "1Dec");
        try {
            sqlFlightDAO.insertFlight(flight);
        } catch (SQLException e) {
            System.out.println(e);
        }
        try {
            List<Flight> list = sqlFlightDAO.listAllFlights();
            for (Flight i : list) {
                System.out.println(i.src);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        String page = "/WEB-INF/jsp/signin.jsp";
        RequestDispatcher requestDispatcher = request.getRequestDispatcher(page);
        requestDispatcher.forward(request, response);
    }
}
