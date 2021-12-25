package com.covoid21.panman.database.controller;

import com.covoid21.panman.database.service.HealthcarePersonnelService;
import com.covoid21.panman.entity.user.HealthcarePersonnel;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@ResponseBody
@RequestMapping(value = "/users")
public class HealthcarePersonnelController extends UserControllerBase<HealthcarePersonnel> {

    private HealthcarePersonnelService healthcarePersonnelService;

    @Override
    @PostMapping
    public HealthcarePersonnel save(@RequestBody HealthcarePersonnel entity) {
        return healthcarePersonnelService.save(entity);
    }

    @Override
    @DeleteMapping("/{id}")
    public HealthcarePersonnel delete(@PathVariable Long id) {

        return healthcarePersonnelService.delete(id);
    }

    @Override
    @GetMapping("/{id}")
    public HealthcarePersonnel get(@PathVariable Long id) {
        return healthcarePersonnelService.findById(id);
    }

    @Override
    @GetMapping
    public List<HealthcarePersonnel> getAll() {
        return super.getAll();
    }
}
