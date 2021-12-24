package com.covoid21.panman.database.repository;

import com.covoid21.panman.entity.Policy;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PolicyRepository extends CrudRepository<Policy, Long> {
    Optional<Policy> findByTitle(String title);
    boolean existsByTitle(String title);
}
