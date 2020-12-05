package com.jspairline.service;

import java.util.ArrayList;

public class StringHelper {

    public static boolean hasID(String commandName) {
        return commandName.contains("?id");
    }

    public static boolean hasMethod(String commandName) {
        return commandName.contains("?method");
    }

    public static boolean validateFileds(ArrayList<String> stringList) {
        for (String string : stringList) {
            if (string.length() < 1)
                return false;
        }
        return true;
    }

    public static boolean hasAttributes(String commandName) {
        return commandName.contains("?id") || commandName.contains("?method");
    }

    public static String getDefaultCommandName(String commandName) {
        if (hasAttributes(commandName))
        {
            int pos =  hasID(commandName) ? commandName.indexOf("?id") : commandName.indexOf("?method") ;
            commandName = commandName.substring(0, pos);
        }
        return commandName;
    }

    public static int getId(String commandName) {
        if (hasID(commandName))
        {
            int pos = commandName.indexOf("?id");
            int lastPos = commandName.contains("?method") ? commandName.indexOf("?method"): commandName.length();
            commandName = commandName.substring(pos + 4, lastPos);
        }
        return Integer.parseInt(commandName);
    }

    public static String getMethod(String commandName) {
        if (hasMethod(commandName))
        {
            int pos = commandName.indexOf("?method=");
            commandName = commandName.substring(pos + 8, commandName.length());
        }
        return commandName;
    }
}
