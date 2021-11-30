package com.covoid21.panman.entity;

import java.util.Date;

public class Announcement {
    int id;
    String message;
    Date date;
    int senderID;

    public Announcement(int id, String message, Date date, int senderID) {
        this.id = id;
        this.message = message;
        this.date = date;
        this.senderID = senderID;
    }
}
