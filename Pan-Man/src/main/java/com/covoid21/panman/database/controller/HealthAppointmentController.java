package com.covoid21.panman.database.controller;

import com.covoid21.panman.database.service.HealthAppointmentService;
import com.covoid21.panman.entity.appointment.HealthAppointment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@ResponseBody
@RequestMapping("/appointments")
public class HealthAppointmentController extends ControllerBase<HealthAppointment> {
    @Autowired
    private HealthAppointmentService healthAppointmentService;

    @Override
    @PostMapping
    public HealthAppointment save(@RequestBody HealthAppointment entity) {
        return healthAppointmentService.save(entity);
    }

    @Override
    @DeleteMapping("/{id}")
    public HealthAppointment delete(@PathVariable Long id) {
        return healthAppointmentService.delete(id);
    }

    @Override
    @GetMapping("/{id}")
    public HealthAppointment get(@PathVariable Long id) {
        return healthAppointmentService.findById(id);
    }

    @Override
    @GetMapping
    public List<HealthAppointment> getAll() {
        return healthAppointmentService.findAll();
    }
}
