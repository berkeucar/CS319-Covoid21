package com.covoid21.panman.database.service;

import com.covoid21.panman.database.repository.SeatingRepository;
import com.covoid21.panman.entity.Seating;
import com.covoid21.panman.entity.SeatingPlan;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SeatingService extends ServiceBase<SeatingPlan> {
    private SeatingRepository repo;

    public SeatingService(SeatingRepository repo) {
        super();
        this.repo = repo;
        this.baseRepo = repo;
    }

    public List<Seating> findByID(Long id) {
        return repo.findByID(id);
    }
}
