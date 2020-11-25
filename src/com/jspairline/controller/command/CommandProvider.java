package com.jspairline.controller.command;

import com.jspairline.controller.command.impl.*;

import java.util.HashMap;
import java.util.Map;

public class CommandProvider {
    private Map<String, Command> commands = new HashMap<>();


    public CommandProvider() {
        commands.put("goToMainPage", new GoToMainCommand());
        commands.put("goToSignInPage", new GoToSignInCommand());
        commands.put("goToSignUpPage", new GoToSignUpCommand());
        commands.put("goToFlightPage", new GoToFlightPage());
        commands.put("registration", new Registration());
        commands.put("authorization", new Authorization());
    }

    public Command getCommand(String commandName) {
        return commands.get(commandName);
    }
}
