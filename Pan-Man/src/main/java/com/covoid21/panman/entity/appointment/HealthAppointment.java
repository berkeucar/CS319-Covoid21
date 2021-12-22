package com.covoid21.panman.entity.appointment;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table( name = "health_appointments" )
@Getter
@Setter
public class HealthAppointment extends Appointment
{
    private String department;
    
    public HealthAppointment() {}
    
    public HealthAppointment(int id, Date date, int hostUserID, String message, String department)
    {
        super(id, date, hostUserID, message);
        this.department = department;
    }
}
