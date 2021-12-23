package com.covoid21.panman.entity.appointment;

import com.covoid21.panman.entity.user.User;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.*;

@Entity
//@Table(name = "facility_appointments")
@DiscriminatorValue("facility")
@Getter
@Setter
public class FacilityAppointment extends Appointment
{
    @ManyToMany
    private Set<User> participants;

    private String facility;
    
    public FacilityAppointment() {}
    
    public FacilityAppointment(Date date, User hostUser, String message, String facility)
    {
        super(date, hostUser, message);
        participants = new HashSet<User>();
        participants.add(hostUser);
        this.facility = facility;
    }

    @Override
    public String toString() {
        return "Facility" + super.toString() + " " + facility;
    }
}
