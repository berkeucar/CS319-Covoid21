package com.covoid21.panman.entity.appointment;

import com.covoid21.panman.entity.TestType;
import com.covoid21.panman.entity.user.User;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import java.util.Date;

@Entity
//@Table( name = "test_appointments" )
@DiscriminatorValue("test")
@Getter
@Setter
public class TestAppointment extends Appointment
{
    @Enumerated
    private TestType testType;
    
    public TestAppointment() {}

    public TestAppointment(Date date, User hostUser, String message, TestType testType) {
        super(date, hostUser, message);
        this.testType = testType;
    }

    public TestAppointment(Long id, Date date, User hostUser, String message, TestType testType)
    {
        super(id, date, hostUser, message);
        this.testType = testType;
    }


}
