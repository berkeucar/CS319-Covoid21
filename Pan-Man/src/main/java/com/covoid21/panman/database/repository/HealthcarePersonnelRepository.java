package com.covoid21.panman.database.repository;

import com.covoid21.panman.entity.appointment.HealthAppointment;
import com.covoid21.panman.entity.user.HealthcarePersonnel;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface HealthcarePersonnelRepository extends UserRepositoryBase<HealthcarePersonnel> {
    List<HealthcarePersonnel> findByDepartment(String department);
    List<HealthcarePersonnel> findByOffice(String office);
    List<HealthcarePersonnel> findByTitle(String title);
    //Optional<HealthcarePersonnel> findByHealthAppointmentsContaining(HealthAppointment appointment);
}
