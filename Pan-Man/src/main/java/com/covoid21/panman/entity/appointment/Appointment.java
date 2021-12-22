package com.covoid21.panman.entity.appointment;

import com.covoid21.panman.entity.user.User;
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
    private Long id;

    private Date date;

    @ManyToOne
    private User hostUser;

    @Column(columnDefinition="text")
    private String message;
    
    public Appointment() {}
    
    public Appointment(Long id, Date date, User hostUser, String message)
    {
        this.id = id;
        this.date = date;
        this.hostUser = hostUser;
        this.message = message;
    }
}
