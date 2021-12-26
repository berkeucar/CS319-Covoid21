package com.covoid21.panman.database.repository;

import com.covoid21.panman.entity.Course;

import com.covoid21.panman.entity.user.Instructor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CourseRepository extends CrudRepository<Course, Long> {
    Optional<Course> findByCodeAndSection(String code, int section);
    boolean existsByCodeAndSection(String code, int section);

    /**
     *
     * @param id    id of the course
     * @return Course of the Given Parameter
     */
    Course findByID(Long id);

    /**
     *
     * @param code
     * @return
     */
    List<Course> findByCode(String code);



    /**
     *
     * @param instructor
     * @return
     */
    List<Course> findByInstructor(Instructor instructor);
}
