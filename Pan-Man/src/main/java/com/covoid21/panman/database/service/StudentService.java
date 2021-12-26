package com.covoid21.panman.database.service;

import com.covoid21.panman.database.repository.StudentRepository;
import com.covoid21.panman.entity.Course;
import com.covoid21.panman.entity.user.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
@Transactional
//@Transactional(propagation = Propagation.REQUIRES_NEW)
public class StudentService extends UserServiceBase<Student> {
    private StudentRepository studentRepo;

    @Autowired
    public StudentService(StudentRepository repo) {
        super(repo);
        studentRepo = repo;
    }
    /*
    @Override
    public Student save(Student entity) {
        if (existsByUniversityID(entity.getUniversityID())) {
            throw new EntityExistsException();
        }
        else {
            return studentRepo.save(entity);
        }
    }

    @Override
    public Student update(Student entity) {
        if (!existsByUniversityID(entity.getUniversityID())) {
            throw new EntityNotFoundException();
        }
        else {
            return studentRepo.save(entity);
        }
    }
    */
    public List<Student> findByCoursesTakenContaining(Course course) {
        return studentRepo.findByCoursesTakenContaining(course);
    }

    public List<Student> findByDormRoom(String dormRoom) {
        return studentRepo.findByDormRoom(dormRoom);
    }

    public List<Student> findByDepartment(String department) {
        return studentRepo.findByDepartment(department);
    }

    @Override
    public Student findByUserUniversityID(int universityID) {
        return studentRepo.findByUserUniversityID(universityID).get();
    }
}
