package com.covoid21.panman.database.repository;

import com.covoid21.panman.entity.Course;
import com.covoid21.panman.entity.user.Student;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface StudentRepository extends UserRepositoryBase<Student> {
    List<Student> findByCoursesTakenContaining(Course course);
    List<Student> findByDormRoom(String dormRoom);
    List<Student> findByDepartment(String department);

    @Override
    @Transactional
    @Modifying
    @Query("UPDATE Student user SET user.isEnabled = TRUE WHERE user.email = ?1")
    int enableUser(String email);
}
