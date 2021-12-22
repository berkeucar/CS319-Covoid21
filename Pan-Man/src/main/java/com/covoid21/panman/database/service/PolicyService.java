package com.covoid21.panman.database.service;

import com.covoid21.panman.database.repository.PolicyRepository;
import com.covoid21.panman.entity.Policy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PolicyService extends ServiceBase<Policy> {
    private PolicyRepository repo;

    @Autowired
    public PolicyService(PolicyRepository repo) {
        super();
        this.repo = repo;
        this.baseRepo = repo;
    }

    public List<Policy> findByID(Long id) {
        return repo.findByID(id);
    }

    public List<Policy> findByTitle(String title) {
        return repo.findByTitle(title);
    }
}
