package com.jspairline.entity;

import java.io.Serializable;

public class Flight implements Serializable {
    private int id;
    public String src;
    public String dest;
    public String timestamp;

    public Flight(int id, String src, String dest, String timestamp) {
        this.id = id;
        this.src = src;
        this.dest = dest;
        this.timestamp = timestamp;
    }

    public int getId() { return id; }

    public String getSrc() { return src; }

    public String getDest() { return dest; }

    public String getTimestamp() { return timestamp; }
}