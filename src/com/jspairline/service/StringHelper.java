package com.jspairline.service;

import java.util.ArrayList;

public class StringHelper {
    public static boolean validateFileds(ArrayList<String> stringList) {
        for (String string : stringList) {
            if (string.length() < 1)
                return false;
        }
        return true;
    }
}
