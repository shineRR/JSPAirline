package com.jspairline.service;

import com.jspairline.entity.Flight;

public class FlightHelper {
    public static Flight configureFlight(String src, String dest, String timestamp) {
        return new Flight(0, src, dest, timestamp);
    }
}
