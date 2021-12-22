package com.covoid21.panman.entity.appointment;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
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
