package com.covoid21.panman.entity.appointment;

import com.covoid21.panman.entity.user.User;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

@Entity
@Table(name = "facility_appointments")
@Getter
@Setter
public class FacilityAppointment extends Appointment
{
    @ManyToMany
    private List<User> participants;

    private String facility;
    
    public FacilityAppointment() {}
    
    public FacilityAppointment(Date date, User hostUser, String message, String facility)
    {
        super(date, hostUser, message);
        participants = new ArrayList<>();
        this.facility = facility;
    }
}
