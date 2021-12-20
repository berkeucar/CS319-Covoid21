package com.covoid21.panman.entity;

import org.springframework.data.annotation.Id;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.util.Date;


@Entity(name = "Announcement")
public class Announcement {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)

    //@Column(name = "id", nullable = false, updatable = false, unique = true)
    private Long id;

    //Column(name = "message")
    private String message;

    //@Column(name = "date")
    private Date date;

    //@Column(name = "sender")
    private long senderID;

    protected Announcement() {}

    public Announcement(Long id, String message, Date date, int senderID) {
        this.id = id;
        this.message = message;
        this.date = date;
        this.senderID = senderID;
    }

    @Override
    public String toString() {
        return String.format("Announcement[id=%d, date=%s]", id, date);
    }
}
