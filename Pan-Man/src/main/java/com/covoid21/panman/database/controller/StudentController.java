package com.covoid21.panman.database.controller;

import com.covoid21.panman.database.service.StudentService;
import com.covoid21.panman.entity.user.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class StudentController extends ControllerBase<Student> {
    @Autowired
    private StudentService studentService;

    @Override
    @GetMapping
    public Student save(@RequestBody Student entity) {
        return studentService.save(entity);
    }

    @Override
    @DeleteMapping("/{id}")
    public Student delete(@PathVariable Long id) {
        return studentService.delete(id);
    }

    @Override
    @GetMapping
    public Student get(@PathVariable Long id) {
        return studentService.findById(id);
    }

    @Override
    @GetMapping
    public List<Student> getAll() {
        return studentService.findAll();
    }
}
