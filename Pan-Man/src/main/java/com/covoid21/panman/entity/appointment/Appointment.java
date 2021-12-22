package com.covoid21.panman.entity.appointment;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "appointments")
@Getter
@Setter
public abstract class Appointment
{
    @Id
    @GeneratedValue
    private int id;
    private Date date;
    private int hostUserID;
    private String message;
    
    public Appointment() {}
    
    public Appointment(int id, Date date, int hostUserID, String message)
    {
        this.id = id;
        this.date = date;
        this.hostUserID = hostUserID;
        this.message = message;
    }
}
