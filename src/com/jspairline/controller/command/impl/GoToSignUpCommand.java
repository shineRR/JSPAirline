package com.jspairline.controller.command.impl;

import com.jspairline.controller.command.Command;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class GoToSignUpCommand implements Command {

    private static final String MAIN_PAGE = "WEB-INF/jsp/main.jsp";
    private static final String SIGNIN_PAGE = "WEB-INF/jsp/signin.jsp";
    private static final String SIGHUP_PAGE = "WEB-INF/jsp/signup.jsp";

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher(SIGHUP_PAGE);
        requestDispatcher.forward(request, response);
    }
}
