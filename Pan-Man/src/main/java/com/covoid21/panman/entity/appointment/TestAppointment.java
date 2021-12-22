package com.covoid21.panman.entity.appointment;

import com.covoid21.panman.entity.TestType;
import com.covoid21.panman.entity.user.User;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table( name = "test_appointments" )
@Getter
@Setter
public class TestAppointment extends Appointment
{
    private TestType testType;
    
    public TestAppointment() {}
    
    public TestAppointment(Long id, Date date, User hostUser, String message, TestType testType)
    {
        super(id, date, hostUser, message);
        this.testType = testType;
    }
}
