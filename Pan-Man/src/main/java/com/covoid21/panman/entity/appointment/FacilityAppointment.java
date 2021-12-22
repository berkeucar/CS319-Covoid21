package com.covoid21.panman.entity.appointment;

import com.covoid21.panman.entity.user.User;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;
import java.util.Date;

@Entity
public class FacilityAppointment extends Appointment
{
    @OneToMany
    private List<User> participants;
    
    public FacilityAppointment() {}
    
    public FacilityAppointment(int id, Date date, int hostUserID, String message)
    {
        super(id, date, hostUserID, message);
//        participants.add(hostUserID);
    }
}
