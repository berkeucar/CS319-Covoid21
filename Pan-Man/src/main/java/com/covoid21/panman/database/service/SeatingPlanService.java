package com.covoid21.panman.database.service;
/*
import com.covoid21.panman.database.repository.SeatingPlanRepository;
import com.covoid21.panman.entity.SeatingPlan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;

@Service
@Transactional
public class SeatingPlanService extends ServiceBase<SeatingPlan> {
    private SeatingPlanRepository seatingPlanRepo;

    @Autowired
    public SeatingPlanService(SeatingPlanRepository repo) {
        super(repo);
        this.seatingPlanRepo = repo;
    }

    @Override
    public SeatingPlan save(SeatingPlan entity) throws EntityExistsException {
        if (seatingPlanRepo.existsByCodeAndSection(entity.getCode(), entity.getSection())) {
            throw new EntityExistsException();
        }
        return seatingPlanRepo.save(entity);
    }

    @Override
    public SeatingPlan update(SeatingPlan entity) throws EntityNotFoundException {
        if (seatingPlanRepo.existsById(entity.getId())) {
            throw new EntityExistsException();
        }
        return seatingPlanRepo.save(entity);
    }

    public SeatingPlan findByCodeAndSection(String code, int section) {
        return seatingPlanRepo.findByCodeAndSection(code, section).get();
    }
}
*/