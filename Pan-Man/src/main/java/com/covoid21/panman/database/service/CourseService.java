package com.covoid21.panman.database.service;

import com.covoid21.panman.database.repository.CourseRepository;
import com.covoid21.panman.entity.Course;
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
    }
}
