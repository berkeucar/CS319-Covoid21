package com.covoid21.panman.entity.appointment;

import java.util.ArrayList;
import java.util.Date;

public class FacilityAppointment extends Appointment {
    private ArrayList<Integer> participants = new ArrayList<Integer>();

    public FacilityAppointment(int id, Date date, int hostUserID, String message) {
        super(id, date, hostUserID, message);
        participants.add(hostUserID);
    }
}
