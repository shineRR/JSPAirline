package com.jspairline.controller.command.impl;

import com.jspairline.controller.command.Command;
import com.jspairline.dao.impl.SQLUserDAO;
import com.jspairline.entity.UserData;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

public class Registration implements Command {

    private static final String MAIN_PAGE = "WEB-INF/jsp/main.jsp";
    private static final String SIGNIN_PAGE = "WEB-INF/jsp/signin.jsp";
    private static final String SIGHUP_PAGE = "WEB-INF/jsp/signup.jsp";

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        SQLUserDAO sqlUserDAO = new SQLUserDAO();
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        String role = request.getParameter("role");
        UserData userData = new UserData(login, role, password);
        boolean result = false;
        try {
            result = sqlUserDAO.registration(userData);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        HttpSession session = request.getSession();
        session.invalidate();
        request.setAttribute("error", result ? "Done" : "Invalid login or password");
        RequestDispatcher requestDispatcher = request.getRequestDispatcher(SIGHUP_PAGE);
        requestDispatcher.forward(request, response);
    }
}
