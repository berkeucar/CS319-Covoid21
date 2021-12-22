package com.covoid21.panman.entity.appointment;

import com.covoid21.panman.entity.user.HealthcarePersonnel;
import com.covoid21.panman.entity.user.User;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table( name = "health_appointments" )
@Getter
@Setter
public class HealthAppointment extends Appointment
{
    private String department;

    @ManyToOne
    private HealthcarePersonnel doctor;
    
    public HealthAppointment() {}
    
    public HealthAppointment(Long id, Date date, User hostUser, String message, String department, HealthcarePersonnel doctor)
    {
        super(id, date, hostUser, message);
        this.department = department;
        this.doctor = doctor;
    }
}
