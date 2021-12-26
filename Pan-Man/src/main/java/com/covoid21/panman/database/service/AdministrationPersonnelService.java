package com.covoid21.panman.database.service;

import com.covoid21.panman.database.repository.AdministrationPersonnelRepository;
import com.covoid21.panman.entity.user.AdministrationPersonnel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;

/**
 * Manages database operations for AdministrativePersonnel
 */
@Service
@Transactional
public class AdministrationPersonnelService extends UserServiceBase<AdministrationPersonnel> {
    private AdministrationPersonnelRepository administrationPersonnelRepo;

    @Autowired
    public AdministrationPersonnelService(AdministrationPersonnelRepository repo) {
        super(repo);
        this.administrationPersonnelRepo = repo;
    }

    /**
     * Finds all AdministrativePersonnel in an office room
     * @param office Office name
     * @return List of AdministrativePersonnel sharing that office
     */
    public List<AdministrationPersonnel> findByOffice(String office) {
        return administrationPersonnelRepo.findByOffice(office);
    }

    /**
     * Finds all AdministrativePersonnel in a department (e.g. registrar's office)
     * @param department
     * @return AdministrativePersonnel in that department
     */
    public List<AdministrationPersonnel> findByDepartment(String department) {
        return administrationPersonnelRepo.findByDepartment(department);
    }

    /**
     * Finds AdministrativePersonnel by title (e.g. director)
     * @param title
     * @return
     */
    public List<AdministrationPersonnel> findByTitle(String title) {
        return administrationPersonnelRepo.findByTitle(title);
    }

    @Override
    public AdministrationPersonnel findByUserUniversityID(int universityID) {
        try {
            return administrationPersonnelRepo.findByUserUniversityID(universityID).get();
        }
        catch (NoSuchElementException e){
            return null;
        }
    }
}
