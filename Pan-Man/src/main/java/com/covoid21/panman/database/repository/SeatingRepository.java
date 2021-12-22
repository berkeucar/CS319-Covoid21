package com.covoid21.panman.database.repository;

import com.covoid21.panman.entity.Seating;
import com.covoid21.panman.entity.SeatingPlan;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SeatingRepository extends CrudRepository<SeatingPlan, Long> {
    /**
     *
     * @param id
     * @return
     */
    List<Seating> findByID(Long id);
}
