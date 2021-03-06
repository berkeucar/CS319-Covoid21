package com.covoid21.panman.database.service;

import com.covoid21.panman.database.repository.HealthcarePersonnelRepository;
import com.covoid21.panman.entity.user.HealthcarePersonnel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@Transactional
public class HealthcarePersonnelService extends UserServiceBase<HealthcarePersonnel> {
    private HealthcarePersonnelRepository healthcarePersonnelRepo;

    @Autowired
    public HealthcarePersonnelService(HealthcarePersonnelRepository repo) {
        super(repo);
        this.healthcarePersonnelRepo = repo;
    }

    public List<HealthcarePersonnel> findByDepartment(String department) {
        return healthcarePersonnelRepo.findByDepartment(department);
    }

    public List<HealthcarePersonnel> findByOffice(String office) {
        return healthcarePersonnelRepo.findByOffice(office);
    }

    public List<HealthcarePersonnel> findByTitle(String title) {
        return healthcarePersonnelRepo.findByTitle(title);
    }

    @Override
    public HealthcarePersonnel findByUserUniversityID(int universityID) {
        try {
            return healthcarePersonnelRepo.findByUserUniversityID(universityID).get();
        }
        catch (NoSuchElementException e){
            return null;
        }
    }
}
