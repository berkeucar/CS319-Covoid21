package com.covoid21.panman.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name = "announcements")
@Getter
@Setter
public class Announcement
{
    @Id
    @GeneratedValue( strategy = GenerationType.AUTO )
    //@Column(name = "id", nullable = false, updatable = false, unique = true)
    private Long id;

    @Column(columnDefinition="text")
    private String message;
    
    private Date date;
    
    private long senderID;
    
    protected Announcement() {}
    
    public Announcement(String message, Date date, long senderID)
    {
        this.message = message;
        this.date = date;
        this.senderID = senderID;
    }
    
    @Override
    public String toString()
    {
        return String.format("Announcement[id=%d, date=%s]", id, date);
    }
}
