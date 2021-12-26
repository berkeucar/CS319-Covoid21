package com.covoid21.panman.database.controller;

import com.covoid21.panman.database.service.StudentService;
import com.covoid21.panman.entity.user.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Student RestController API class, includes save(...),
 * delete(...), get(...), getAll() methods
 */
@RestController
@RequestMapping(value = "/student")
public class StudentController extends ControllerBase<Student> {
    @Autowired
    private StudentService studentService;

    @Override
    @PostMapping
    public Student save(@RequestBody Student entity) {
        return studentService.save(entity);
    }

    @Override
    @DeleteMapping("/{id}")
    public Student delete(@PathVariable Long id) {
        return studentService.delete(id);
    }

    @Override
    @GetMapping("/{id}")
    public Student get(@PathVariable Long id) {
        return studentService.findById(id);
    }

    @Override
    @GetMapping
    public List<Student> getAll() {
        return studentService.findAll();
    }
}
