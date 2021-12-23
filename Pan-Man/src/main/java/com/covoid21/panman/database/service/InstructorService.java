package com.covoid21.panman.database.service;

import com.covoid21.panman.database.repository.InstructorRepository;
import com.covoid21.panman.database.repository.UserRepositoryBase;
import com.covoid21.panman.entity.user.Instructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class InstructorService extends UserServiceBase<Instructor> {
    private InstructorRepository instructorRepo;

    public InstructorService(InstructorRepository repo) {
        super(repo);
        this.instructorRepo = repo;
    }

    public List<Instructor> findByDepartment(String department) {
        return instructorRepo.findByDepartment(department);
    }

    public List<Instructor> findByOffice(String office) {
        return instructorRepo.findByOffice(office);
    }
}
