package com.jspairline.controller.command.impl;

import com.jspairline.controller.command.Command;
import com.jspairline.dao.impl.SQLUserDAO;
import com.jspairline.entity.User;
import com.jspairline.service.StringHelper;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class Authorization implements Command {

    private static final String MAIN_PAGE = "WEB-INF/jsp/main.jsp";
    private static final String SIGNIN_PAGE = "WEB-INF/jsp/signin.jsp";
    private static final String FLIGHT_PAGE = "WEB-INF/jsp/flightPage.jsp";

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        SQLUserDAO sqlUserDAO = new SQLUserDAO();
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        User user = null;
        try {
            user = sqlUserDAO.authentification(login, password);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        HttpSession session = request.getSession();
        if (user != null) {
            session.setAttribute("role", user.getRole());
            RequestDispatcher requestDispatcher = request.getRequestDispatcher(MAIN_PAGE);
            requestDispatcher.forward(request, response);
        } else {
            session.invalidate();
            request.setAttribute("error", "Invalid login or password");
            RequestDispatcher requestDispatcher = request.getRequestDispatcher(SIGNIN_PAGE);
            requestDispatcher.forward(request, response);
        }
    }
}
