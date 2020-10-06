package com.jspairline.controller.command.impl;

import com.jspairline.controller.command.Command;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Registration implements Command {

    private String MAIN_PAGE = "WEB-INF/jsp/main.jsp";
    private String SIGNIN_PAGE = "WEB-INF/jsp/signin.jsp";
    private String SIGHUP_PAGE = "WEB-INF/jsp/signup.jsp";

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
