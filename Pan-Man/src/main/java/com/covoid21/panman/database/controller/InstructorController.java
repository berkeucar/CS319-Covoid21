package com.covoid21.panman.database.controller;

import com.covoid21.panman.database.service.InstructorService;
import com.covoid21.panman.entity.user.Instructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Instructor RestController API class, includes save(...),
 * delete(...), get(...), getAll() methods
 */
@RestController
@RequestMapping(value = "/api/users/instructor")
public class InstructorController extends UserControllerBase<Instructor> {
    @Autowired
    private InstructorService instructorService;

    @Override
    @PostMapping
    public Instructor save(@RequestBody Instructor entity) {
        return instructorService.save(entity);
    }

    @Override
    @DeleteMapping("/{id}")
    public Instructor delete(@PathVariable Long id) {
        return instructorService.delete(id);
    }

    @Override
    @GetMapping("/{id}")
    public Instructor get(@PathVariable Long id) {
        return instructorService.findById(id);
    }

    @Override
    @GetMapping
    public List<Instructor> getAll() {
        return instructorService.findAll();
    }
}
