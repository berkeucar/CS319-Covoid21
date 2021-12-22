package com.covoid21.panman.database.service;

import com.covoid21.panman.database.repository.CourseRepository;
import com.covoid21.panman.entity.Course;
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
    }
}
