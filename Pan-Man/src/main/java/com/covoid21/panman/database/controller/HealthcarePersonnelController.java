package com.covoid21.panman.database.controller;

import com.covoid21.panman.entity.user.HealthcarePersonnel;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/users", params = "user_type=healthcare")
public class HealthcarePersonnelController extends UserControllerBase<HealthcarePersonnel> {

    @Override
    public HealthcarePersonnel save(HealthcarePersonnel entity) {
        return super.save(entity);
    }

    @Override
    public HealthcarePersonnel delete(@PathVariable Long id) {
        return super.delete(id);
    }

    @Override
    public @ResponseBody HealthcarePersonnel get(@PathVariable Long id) {
        return super.get(id);
    }

    @Override
    public @ResponseBody List<HealthcarePersonnel> getAll() {
        return super.getAll();
    }
}
