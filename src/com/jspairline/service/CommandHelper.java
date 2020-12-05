package com.jspairline.service;

import com.jspairline.controller.command.Command;
import com.jspairline.controller.command.CommandProvider;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CommandHelper {
    public static void redirect(String commandName, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
        CommandProvider commandProvider = new CommandProvider();
        Command command = commandProvider.getCommand(commandName);
        command.execute(request, response);
    }
}
