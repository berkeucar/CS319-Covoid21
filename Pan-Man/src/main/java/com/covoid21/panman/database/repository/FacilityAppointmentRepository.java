package com.covoid21.panman.database.repository;

import com.covoid21.panman.entity.appointment.FacilityAppointment;
import com.covoid21.panman.entity.user.User;

import java.util.List;

public interface FacilityAppointmentRepository extends AppointmentRepositoryBase<FacilityAppointment> {
    List<FacilityAppointment> findByParticipantsContaining(User participant);
    List<FacilityAppointment> findByFacility(String facility);
}
