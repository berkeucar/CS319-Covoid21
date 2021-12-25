package com.covoid21.panman.database.repository;

import com.covoid21.panman.entity.Course;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CourseRepository extends CrudRepository<Course, Long> {
    Optional<Course> findByCodeAndSection(String code, int section);
    boolean existsByCodeAndSection(String code, int section);
}
