package com.covoid21.panman.database.controller;

import com.covoid21.panman.entity.appointment.FacilityAppointment;

import java.util.List;

public class FacilityAppointmentController extends ControllerBase<FacilityAppointment> {
    @Override
    public FacilityAppointment save(FacilityAppointment entity) {
        return super.save(entity);
    }

    @Override
    public FacilityAppointment delete(Long id) {
        return super.delete(id);
    }

    @Override
    public FacilityAppointment get(Long id) {
        return super.get(id);
    }

    @Override
    public List<FacilityAppointment> getAll() {
        return super.getAll();
    }
}

