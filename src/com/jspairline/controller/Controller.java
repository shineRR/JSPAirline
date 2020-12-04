package com.jspairline.controller;

import com.jspairline.controller.command.CommandProvider;
import com.jspairline.controller.command.Command;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;

public class Controller extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private static final String PARAMETER_COMMAND = "command";

    private final CommandProvider provider = new CommandProvider();

    public Controller() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String commandName = request.getParameter(PARAMETER_COMMAND);
        Command command = provider.getCommand(commandName);

        command.execute(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("2");
        doGet(request, response);
    }
}
