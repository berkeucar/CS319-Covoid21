package com.covoid21.panman.database.repository;

import com.covoid21.panman.entity.Course;
import com.covoid21.panman.entity.user.Student;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends UserRepositoryBase<Student> {
    List<Student> findByCoursesTakenContaining(Course course);
    List<Student> findByDormRoom(String dormRoom);
    List<Student> findByDepartment(String department);
}
