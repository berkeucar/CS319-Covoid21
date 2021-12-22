package com.covoid21.panman.entity.appointment;

import com.covoid21.panman.entity.TestType;

import javax.persistence.Entity;
import java.util.Date;

@Entity
public class TestAppointment extends Appointment
{
    private TestType testType;
    
    public TestAppointment() {}
    
    public TestAppointment(int id, Date date, int hostUserID, String message, TestType testType)
    {
        super(id, date, hostUserID, message);
        this.testType = testType;
    }
}
