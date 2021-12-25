package com.covoid21.panman.database.repository;

import com.covoid21.panman.entity.appointment.HealthAppointment;
import com.covoid21.panman.entity.user.HealthcarePersonnel;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
public interface HealthcarePersonnelRepository extends UserRepositoryBase<HealthcarePersonnel> {
    List<HealthcarePersonnel> findByDepartment(String department);
    List<HealthcarePersonnel> findByOffice(String office);
    List<HealthcarePersonnel> findByTitle(String title);
    @Override
    @Transactional
    @Modifying
    @Query("UPDATE HealthcarePersonnel user SET user.isEnabled = TRUE WHERE user.email = ?1")
    int enableUser(String email);
}
