package com.covoid21.panman.database.controller;

import com.covoid21.panman.database.service.PolicyService;
import com.covoid21.panman.entity.Policy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@ResponseBody
@RequestMapping("/policies")
public class PolicyController extends ControllerBase<Policy> {
    @Autowired
    private PolicyService policyService;

    @Override
    @PostMapping
    public Policy save(@RequestBody Policy entity) {
        return policyService.save(entity);
    }

    @Override
    @DeleteMapping( "/{id}" )
    public Policy delete(@PathVariable Long id) {
        return policyService.delete(id);
    }

    @Override
    @GetMapping( "/{id}" )
    public Policy get(@PathVariable Long id) {
        return policyService.findById(id);
    }

    @Override
    @GetMapping
    public List<Policy> getAll() {
        return policyService.findAll();
    }
}
