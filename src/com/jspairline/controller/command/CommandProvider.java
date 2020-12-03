package com.jspairline.controller.command;

import com.jspairline.controller.command.impl.*;
import com.jspairline.dao.impl.SQLFlightDAO;
import com.jspairline.entity.Flight;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class CommandProvider {
    private Map<String, Command> commands = new HashMap<>();

    public CommandProvider() {
        SQLFlightDAO sqlFlightDAO = new SQLFlightDAO("jdbc:mysql://localhost:8080/mysqljdbc", "root", "");
        Flight flight = new Flight(1, "old", "new", "1Dec");
        try {
            sqlFlightDAO.insertFlight(flight);
        } catch (SQLException e) {
            System.out.println("1");
        }
        commands.put("goToMainPage", new GoToMainCommand());
        commands.put("goToSignInPage", new GoToSignInCommand());
        commands.put("goToSignUpPage", new GoToSignUpCommand());
        commands.put("goToFlightPage", new GoToFlightPage());
        commands.put("goToNewFlight", new GoToNewFlight());
        commands.put("listFlights", new GoToListFlights());
//        commands.put("updateFlight", );
//        commands.put("listFlights", );
        commands.put("registration", new Registration());
        commands.put("authorization", new Authorization());
    }


    public Command getCommand(String commandName) {
        return commands.get(commandName);
    }
}
