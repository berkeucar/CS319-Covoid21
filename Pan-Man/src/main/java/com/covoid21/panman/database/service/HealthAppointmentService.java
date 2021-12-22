package com.covoid21.panman.database.service;

import com.covoid21.panman.database.repository.AppointmentRepositoryBase;
import com.covoid21.panman.database.repository.HealthAppointmentRepository;
import com.covoid21.panman.entity.appointment.HealthAppointment;
import com.covoid21.panman.entity.user.HealthcarePersonnel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HealthAppointmentService extends AppointmentServiceBase<HealthAppointment> {
    private HealthAppointmentRepository healthAppointmentRepo;

    @Autowired
    public HealthAppointmentService(HealthAppointmentRepository repo) {
        super(repo);
        this.healthAppointmentRepo = repo;
    }

    public List<HealthAppointment> findByDepartment(String department) {
        return healthAppointmentRepo.findByDepartment(department);
    }

    public List<HealthAppointment> findByDoctor(HealthcarePersonnel doctor) {
        return healthAppointmentRepo.findByDoctor(doctor);
    }
}
