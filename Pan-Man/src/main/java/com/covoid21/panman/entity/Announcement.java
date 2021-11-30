package com.covoid21.panman.entity;

import java.util.Date;

public class Announcement {
    private int id;
    private String message;
    private Date date;
    private int senderID;

    public Announcement(int id, String message, Date date, int senderID) {
        this.id = id;
        this.message = message;
        this.date = date;
        this.senderID = senderID;
    }
}
