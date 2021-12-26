package com.covoid21.panman.database.controller;

import com.covoid21.panman.database.service.FacilityAppointmentService;
import com.covoid21.panman.entity.appointment.FacilityAppointment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * FacilityAppointment RestController API class, includes save(...),
 * delete(...), get(...), getAll() methods
 */
@RestController
@ResponseBody
@RequestMapping("/api/appointments/facility")
public class FacilityAppointmentController extends ControllerBase<FacilityAppointment> {
    @Autowired
    private FacilityAppointmentService facilityAppointmentService;
    @Override
    @PostMapping
    public FacilityAppointment save(@RequestBody FacilityAppointment entity) {
        return facilityAppointmentService.save(entity);
    }

    @Override
    @DeleteMapping( "/{id}" )
    public FacilityAppointment delete(@PathVariable Long id) {
        return facilityAppointmentService.delete(id);
    }

    @Override
    @GetMapping( "/{id}" )
    public FacilityAppointment get(Long id) {
        return facilityAppointmentService.findById(id);
    }

    @Override
    @GetMapping
    public List<FacilityAppointment> getAll() {
        return facilityAppointmentService.findAll();
    }
}

