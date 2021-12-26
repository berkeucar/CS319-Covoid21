package com.covoid21.panman.database.service;

import com.covoid21.panman.database.repository.StudentCloseSeatsRepository;
import com.covoid21.panman.database.repository.StudentRepository;
import com.covoid21.panman.entity.StudentCloseSeats;
import com.covoid21.panman.entity.user.Student;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;

@Service
@Transactional
@Getter
public class StudentCloseSeatsService extends ServiceBase<StudentCloseSeats> {
    private StudentCloseSeatsRepository studentCloseSeatsRepo;
    private StudentService studentService;

    @Autowired
    public StudentCloseSeatsService(StudentCloseSeatsRepository repo, StudentService studentService) {
        super(repo);
        this.studentCloseSeatsRepo = repo;
        this.studentService = studentService;
    }

    @Override
    public StudentCloseSeats save(StudentCloseSeats entity) throws EntityExistsException {
        if (studentCloseSeatsRepo.existsByCodeAndSection(entity.getCode(), entity.getSection())) {
            throw new EntityExistsException();
        }
        return studentCloseSeatsRepo.save(entity);
    }

    @Override
    public StudentCloseSeats update(StudentCloseSeats entity) throws EntityNotFoundException {
        if (!studentCloseSeatsRepo.existsByCodeAndSection(entity.getCode(), entity.getSection())) {
            throw new EntityNotFoundException();
        }
        return studentCloseSeatsRepo.save(entity);
    }

    public StudentCloseSeats addStudent(StudentCloseSeats seats, Student s) {
        seats.addStudent(s);
        /*
        try {
            studentService.update(s);
        } catch (EntityNotFoundException e) {
            throw new EntityNotFoundException();
        }
        */
        try {
            return update(seats);
        } catch (EntityNotFoundException e) {
            throw new EntityNotFoundException();
        }
    }

    public StudentCloseSeats findByCodeAndSection(String code, int section) {
        return studentCloseSeatsRepo.findByCodeAndSection(code, section).get();
    }
}
