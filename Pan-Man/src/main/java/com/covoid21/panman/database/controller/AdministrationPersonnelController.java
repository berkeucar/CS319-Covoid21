package com.covoid21.panman.database.controller;

import com.covoid21.panman.database.service.AdministrationPersonnelService;
import com.covoid21.panman.entity.user.AdministrationPersonnel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * AdministrationPersonnel RestController API class, includes save(...),
 * delete(...), get(...), getAll() methods
 */
@RestController
@ResponseBody
@RequestMapping(value = "/administration")
public class AdministrationPersonnelController extends ControllerBase<AdministrationPersonnel> {

    @Autowired
    private AdministrationPersonnelService administrationPersonnelService;

    @Override
    @PostMapping
    public AdministrationPersonnel save(@RequestBody AdministrationPersonnel entity) {
        return administrationPersonnelService.save(entity);
    }

    @Override
    @DeleteMapping("/{id}")
    public AdministrationPersonnel delete(@PathVariable Long id) {

        return administrationPersonnelService.delete(id);
    }

    @Override
    @GetMapping("/{id}")
    public AdministrationPersonnel get(@PathVariable Long id) {
        return administrationPersonnelService.findById(id);
    }

    @Override
    @GetMapping
    public List<AdministrationPersonnel> getAll() {
        return administrationPersonnelService.findAll();
    }
}
