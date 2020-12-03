package com.jspairline.controller.command.impl;

import com.jspairline.controller.command.Command;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class GoToNewFlight implements Command {

    private void insertBook(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        String src = request.getParameter("src");
        String dest = request.getParameter("dest");
        String timestamp = request.getParameter("timestamp");


    }

@Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String page = "/WEB-INF/jsp/flightForm.jsp";
        RequestDispatcher requestDispatcher = request.getRequestDispatcher(page);
        requestDispatcher.forward(request, response);
    }
}
