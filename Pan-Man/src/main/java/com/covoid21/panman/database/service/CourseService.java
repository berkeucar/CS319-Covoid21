package com.covoid21.panman.database.service;

import com.covoid21.panman.database.repository.CourseRepository;
import com.covoid21.panman.entity.Course;
<<<<<<< HEAD
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;

@Service
@Transactional
public class CourseService extends ServiceBase<Course> {
    private CourseRepository courseRepo;

    @Autowired
    public CourseService(CourseRepository repo) {
        super(repo);
        this.courseRepo = repo;
    }

    @Override
    public Course save(Course entity) throws EntityExistsException {
        if (courseRepo.existsByCodeAndSection(entity.getCode(), entity.getSection())) {
            throw new EntityExistsException();
        }
        return courseRepo.save(entity);
    }

    @Override
    public Course update(Course entity) throws EntityNotFoundException {
        if (!courseRepo.existsById(entity.getId())) {
            throw new EntityNotFoundException();
        }
        return courseRepo.save(entity);
=======
import com.covoid21.panman.entity.user.Instructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CourseService extends ServiceBase<Course> {
    private CourseRepository repo;

    @Autowired
    public CourseService(CourseRepository repo) {
        super();
        this.repo = repo;
        this.baseRepo = repo;
    }

    public Course findByID(Long id) {
        return repo.findByID(id);
    }

    public List<Course> findByCode(String code) {
        return repo.findByCode(code);
    }

    public Course findByCodeAndSection(String code, int section) {
        return repo.findByCodeAndSection(code, section);
    }

    public List<Course> findByInstructor(Instructor instructor) {
        return repo.findByInstructor(instructor);
>>>>>>> frontend
    }
}
