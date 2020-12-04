package com.jspairline.controller.command.impl;

import com.jspairline.controller.command.Command;
import com.jspairline.dao.impl.SQLUserDAO;
import com.jspairline.entity.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

public class Authorization implements Command {

    private static final String MAIN_PAGE = "WEB-INF/jsp/main.jsp";
    private static final String SIGNIN_PAGE = "WEB-INF/jsp/signin.jsp";

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
        if (user != null) {
            HttpSession session = request.getSession();
            session.setAttribute("login", login);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher(MAIN_PAGE);
            requestDispatcher.forward(request, response);
        } else {
            RequestDispatcher requestDispatcher = request.getRequestDispatcher(SIGNIN_PAGE);
            requestDispatcher.forward(request, response);
        }
    }
}
