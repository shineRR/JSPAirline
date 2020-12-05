package com.jspairline.controller.command.impl;

import com.jspairline.controller.command.Command;
import com.jspairline.controller.command.CommandProvider;
import com.jspairline.dao.impl.SQLFlightDAO;
import com.jspairline.entity.Flight;
import com.jspairline.service.CommandHelper;
import com.jspairline.service.FlightHelper;
import com.jspairline.service.StringHelper;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

public class GoToNewFlight extends HttpServlet implements Command {

    private static final String FLIGHT_PAGE = "WEB-INF/jsp/flightPage.jsp";
    private static final String FLIGHT_FORM_PAGE = "WEB-INF/jsp/flightForm.jsp";
    private static final String SIGHUP_PAGE = "WEB-INF/jsp/signup.jsp";

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String srcCity = request.getParameter("src");
        String destCity = request.getParameter("dest");
        String timestamp = request.getParameter("timestamp");
        SQLFlightDAO sqlFlightDAO = new SQLFlightDAO();
        Flight flight = FlightHelper.configureFlight(srcCity, destCity, timestamp);
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
        String queryString = request.getQueryString();
        if (request.getMethod().equalsIgnoreCase("POST") && !StringHelper.hasMethod(queryString))
        {
            doPost(request, response);
            CommandProvider commandName = new CommandProvider();
            Command command = commandName.getCommand("goToFlightPage");
            command.execute(request, response);
            return;
        }

        if (StringHelper.hasAttributes(queryString)) {
            int id = -1;
            if (StringHelper.hasID(queryString))
                id = StringHelper.getId(queryString);
            String method = StringHelper.getMethod(queryString);
            SQLFlightDAO sqlFlightDAO = new SQLFlightDAO();
            try {
                Flight flight = sqlFlightDAO.getFlight(id);
                if (flight == null) {
                    CommandHelper.redirect("goToFlightPage", request, response);
                    return;
                }
                switch (method) {
                    case "edit" ->
                        request.setAttribute("flight", flight);
                    case "update" -> {
                        String srcCity = request.getParameter("src");
                        String destCity = request.getParameter("dest");
                        String timestamp = request.getParameter("timestamp");
                        Flight forUpdate = FlightHelper.configureFlight(srcCity, destCity, timestamp);
                        forUpdate.setId(flight.getId());
                        sqlFlightDAO.updateFlight(forUpdate);
                        CommandHelper.redirect("goToFlightPage", request, response);
                        return;
                    }
                    case "delete" -> {
                        sqlFlightDAO.deleteFlight(flight);
                        CommandHelper.redirect("goToFlightPage", request, response);
                        return;
                    }
                }
            }
            catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

        RequestDispatcher requestDispatcher = request.getRequestDispatcher(FLIGHT_FORM_PAGE);
        requestDispatcher.forward(request, response);
    }
}
