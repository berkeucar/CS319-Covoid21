package com.covoid21.panman.entity.appointment;

import com.covoid21.panman.entity.user.HealthcarePersonnel;
import com.covoid21.panman.entity.user.User;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table( name = "health_appointments" )
@Getter
@Setter
public class HealthAppointment extends Appointment
{
    private String department;

    //@ManyToOne(cascade = CascadeType.ALL)
    //@ManyToOne
    @ManyToOne
    private HealthcarePersonnel doctor;
    
    public HealthAppointment() {}
    
    public HealthAppointment(Date date, User hostUser, String message, String department, HealthcarePersonnel doctor)
    {
        super(date, hostUser, message);
        this.department = department;
        this.doctor = doctor;
    }
}
