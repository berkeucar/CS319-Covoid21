package com.covoid21.panman.database.repository;

import com.covoid21.panman.entity.StudentCloseSeats;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentCloseSeatsRepository extends CrudRepository<StudentCloseSeats, Long> {
    boolean existsByCodeAndSection(String code, int section);
    Optional<StudentCloseSeats> findByCodeAndSection(String code, int section);
}
