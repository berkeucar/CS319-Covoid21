package com.covoid21.panman.entity.appointment;

import java.util.Date;

public class Appointment {
    private final int id;
    private Date date;
    private int hostUserID;
    private String message;

    public Appointment(int id, Date date, int hostUserID, String message) {
        this.id = id;
        this.date = date;
        this.hostUserID = hostUserID;
        this.message = message;
    }
}
