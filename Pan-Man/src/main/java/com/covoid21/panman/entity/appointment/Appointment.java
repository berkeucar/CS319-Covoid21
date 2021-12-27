package com.covoid21.panman.entity.appointment;

import com.covoid21.panman.entity.user.User;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "appointment_type", discriminatorType = DiscriminatorType.STRING)
@Table(name = "appointments")
@Getter
@Setter
public abstract class Appointment
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id = 0L;

    @DateTimeFormat(pattern = "yyyy-mm-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-mm-dd HH:mm:ss")
    private Date date;

    @ManyToOne
    private User hostUser;

    @Column(columnDefinition="text")
    private String message;

    @Autowired
    protected Appointment() {
        super();
    }

    @Autowired
    public Appointment(Date date, User hostUser, String message)
    {
        this.date = date;
        this.hostUser = hostUser;
        this.message = message;
    }

    @Autowired
    public Appointment(Long id, Date date, User hostUser, String message) {
        this.id = id;
        this.date = date;
        this.hostUser = hostUser;
        this.message = message;
    }

    @Override
    public String toString() {
        return "Appointment " + id + " " + date;
    }
}
