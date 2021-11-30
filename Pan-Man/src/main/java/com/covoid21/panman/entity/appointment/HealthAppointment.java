package com.covoid21.panman.entity.appointment;

import java.util.Date;

public class HealthAppointment extends Appointment {
    private String department;

    public HealthAppointment(int id, Date date, int hostUserID, String message, String department) {
        super(id, date, hostUserID, message);
        this.department = department;
    }
}
