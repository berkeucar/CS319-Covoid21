package com.covoid21.panman.database.repository;

import com.covoid21.panman.entity.user.AdministrationPersonnel;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdministrationPersonnelRepository extends UserRepositoryBase<AdministrationPersonnel> {
    List<AdministrationPersonnel> findByOffice(String office);
    List<AdministrationPersonnel> findByDepartment(String department);
    List<AdministrationPersonnel> findByTitle(String title);
}
