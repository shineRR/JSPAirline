package com.jspairline.controller.command.impl;

import com.jspairline.controller.command.Command;
import com.jspairline.dao.impl.SQLUserDAO;
import com.jspairline.entity.UserData;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;

public class Registration implements Command {

    private static final String MAIN_PAGE = "WEB-INF/jsp/main.jsp";
    private static final String SIGNIN_PAGE = "WEB-INF/jsp/signin.jsp";
    private static final String SIGHUP_PAGE = "WEB-INF/jsp/signup.jsp";

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
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
        System.out.println(result);
    }
}
