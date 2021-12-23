package com.covoid21.panman.database.repository;

import com.covoid21.panman.entity.user.Instructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InstructorRepository extends UserRepositoryBase<Instructor> {
    List<Instructor> findByDepartment(String department);
    List<Instructor> findByOffice(String office);
}
