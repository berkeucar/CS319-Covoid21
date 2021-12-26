package com.covoid21.panman.database.controller;

import com.covoid21.panman.database.service.CourseService;
import com.covoid21.panman.entity.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Course RestController API class, includes save(...),
 * delete(...), get(...), getAll() methods
 */
@RestController
@ResponseBody
@RequestMapping("/api/courses")
public class CourseController extends ControllerBase<Course> {
    @Autowired
    private CourseService courseService;

    @Override
    @PostMapping
    public Course save(@RequestBody Course entity) {
        return courseService.save(entity);
    }


    @Override
    @DeleteMapping( "/{id}" )
    public Course delete(@PathVariable Long id) {
        return courseService.delete(id);
    }


    @Override
    @GetMapping( "/{id}" )
    public Course get(@PathVariable Long id) {
        return courseService.findById(id);
    }

    @Override
    @GetMapping
    public List<Course> getAll() {
        return courseService.findAll();
    }
}
