package com.covoid21.panman.database.repository;

import com.covoid21.panman.entity.user.Instructor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface InstructorRepository extends UserRepositoryBase<Instructor> {
    List<Instructor> findByDepartment(String department);
    List<Instructor> findByOffice(String office);

    @Override
    @Transactional
    @Modifying
    @Query("UPDATE Instructor user SET user.isEnabled = TRUE WHERE user.email = ?1")
    int enableUser(String email);
}
