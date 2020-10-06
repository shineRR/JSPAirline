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
//        commands.put("registration", new RegistrationCommand());
//        commands.put("find_book", new FindBookCommand());
//        commands.put("go_to_index", new GoToIndexPageCommand());
//        commands.put("change_locale", new ChangeLocale());
    }

    public Command getCommand(String commandName) {
        return commands.get(commandName);
    }
}
