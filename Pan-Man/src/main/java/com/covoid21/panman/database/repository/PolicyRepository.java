package com.covoid21.panman.database.repository;

import com.covoid21.panman.entity.Policy;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


import java.util.List;

@Repository
public interface PolicyRepository extends CrudRepository<Policy, Long> {
    /**
     *
     * @param id
     * @return
     */
    List<Policy> findByID(Long id);

    /**
     *
     * @param title
     * @return
     */
    List<Policy> findByTitle(String title);
    boolean existsByTitle(String title);

}
