package com.covoid21.panman.database.repository;

import com.covoid21.panman.entity.user.AdministrationPersonnel;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
public interface AdministrationPersonnelRepository extends UserRepositoryBase<AdministrationPersonnel> {
    List<AdministrationPersonnel> findByOffice(String office);
    List<AdministrationPersonnel> findByDepartment(String department);
    List<AdministrationPersonnel> findByTitle(String title);

    @Override
    @Transactional
    @Modifying
    @Query("UPDATE AdministrationPersonnel user SET user.isEnabled = TRUE WHERE user.email = ?1")
    int enableUser(String email);

    @Override
    @Query("SELECT ap FROM AdministrationPersonnel ap WHERE ap.universityID = ?1")
    Optional<AdministrationPersonnel> findByUserUniversityID(int id);
}
