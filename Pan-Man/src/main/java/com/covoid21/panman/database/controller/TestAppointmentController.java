package com.covoid21.panman.database.controller;

import com.covoid21.panman.database.service.TestAppointmentService;
import com.covoid21.panman.entity.appointment.TestAppointment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * TestAppointment RestController API class, includes save(...),
 * delete(...), get(...), getAll() methods
 */
@RestController
@ResponseBody
@RequestMapping("/api/appointments/test")
public class TestAppointmentController extends ControllerBase<TestAppointment> {
    @Autowired
    private TestAppointmentService testAppointmentService;

    @Override
    @PostMapping
    public TestAppointment save(@RequestBody TestAppointment entity) {
        return testAppointmentService.save(entity);
    }

    @Override
    @DeleteMapping("/{id}")
    public TestAppointment delete(@PathVariable Long id) {
        return testAppointmentService.delete(id);
    }

    @Override
    @GetMapping("/{id}")
    public TestAppointment get(@PathVariable Long id) {
        return testAppointmentService.findById(id);
    }

    @Override
    @GetMapping
    public List<TestAppointment> getAll() {
        return testAppointmentService.findAll();
    }
}
