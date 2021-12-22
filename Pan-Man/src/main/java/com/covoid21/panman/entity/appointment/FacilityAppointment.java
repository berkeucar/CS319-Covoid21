package com.covoid21.panman.entity.appointment;

import com.covoid21.panman.entity.user.User;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;
import java.util.Date;

@Entity
@Table( name = "facility_appointments" )
@Getter
@Setter
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
