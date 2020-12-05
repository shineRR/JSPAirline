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

    public void setId(int id) { this.id = id; }

    public String getSrc() { return src; }

    public void setSrc(String src) { this.src = src; }

    public String getDest() { return dest; }

    public void setDest(String dest) { this.dest = dest; }

    public String getTimestamp() { return timestamp; }

    public void setTimestamp(String timestamp) { this.timestamp = timestamp; }
}