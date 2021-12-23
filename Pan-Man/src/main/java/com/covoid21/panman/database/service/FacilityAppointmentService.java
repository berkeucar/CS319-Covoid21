package com.covoid21.panman.database.service;

import com.covoid21.panman.database.repository.AppointmentRepositoryBase;
import com.covoid21.panman.database.repository.FacilityAppointmentRepository;
import com.covoid21.panman.entity.appointment.FacilityAppointment;
import com.covoid21.panman.entity.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@Transactional
public class FacilityAppointmentService extends AppointmentServiceBase<FacilityAppointment> {
    private FacilityAppointmentRepository facilityAppointmentRepo;

    @Autowired
    public FacilityAppointmentService(FacilityAppointmentRepository repo) {
        super(repo);
        this.facilityAppointmentRepo = repo;
    }

    public List<FacilityAppointment> findByParticipantsContaining(User participant) {
        return facilityAppointmentRepo.findByParticipantsContaining(participant);
    }

    public List<FacilityAppointment> findByFacility(String facility) {
        return facilityAppointmentRepo.findByFacility(facility);
    }

}
