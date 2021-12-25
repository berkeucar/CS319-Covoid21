package com.covoid21.panman.database.service;

import com.covoid21.panman.database.repository.StudentCloseSeatsRepository;
import com.covoid21.panman.entity.StudentCloseSeats;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;

@Service
@Transactional
public class StudentCloseSeatsService extends ServiceBase<StudentCloseSeats> {
    private StudentCloseSeatsRepository studentCloseSeatsRepo;

    public StudentCloseSeatsService(StudentCloseSeatsRepository repo) {
        super(repo);
        this.studentCloseSeatsRepo = repo;
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
        if (!studentCloseSeatsRepo.existsById(entity.getId())) {
            throw new EntityNotFoundException();
        }
        return studentCloseSeatsRepo.save(entity);
    }

    public StudentCloseSeats findByCodeAndSection(String code, int section) {
        return studentCloseSeatsRepo.findByCodeAndSection(code, section).get();
    }
}
