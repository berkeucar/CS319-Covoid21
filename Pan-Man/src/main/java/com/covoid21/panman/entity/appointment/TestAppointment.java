package com.covoid21.panman.entity.appointment;

import com.covoid21.panman.entity.TestType;

import java.util.Date;

public class TestAppointment extends Appointment {
    private TestType testType;

    public TestAppointment(int id, Date date, int hostUserID, String message, TestType testType) {
        super(id, date, hostUserID, message);
        this.testType = testType;
    }
}
