package com.covoid21.panman.database.repository;

import com.covoid21.panman.entity.appointment.FacilityAppointment;
import com.covoid21.panman.entity.user.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FacilityAppointmentRepository extends AppointmentRepositoryBase<FacilityAppointment> {
    List<FacilityAppointment> findByParticipantsContaining(User participant);
    List<FacilityAppointment> findByFacility(String facility);
}
