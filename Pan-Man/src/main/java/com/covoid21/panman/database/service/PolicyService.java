package com.covoid21.panman.database.service;

import com.covoid21.panman.database.repository.PolicyRepository;
import com.covoid21.panman.entity.Policy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import java.util.Optional;

@Service
@Transactional
public class PolicyService extends ServiceBase<Policy> {
    private PolicyRepository policyRepo;

    @Autowired
    public PolicyService(PolicyRepository repo) {
        super(repo);
        this.policyRepo = repo;
    }

    @Override
    public Policy save(Policy policy) {
        if (policyRepo.existsById(policy.getId()) || policyRepo.existsByTitle(policy.getTitle())) {
            throw new EntityExistsException();
        }
        return policyRepo.save(policy);
    }

    @Override
    public Policy update(Policy policy) {
        Optional<Policy> tmp = policyRepo.findById(policy.getId());

        if (tmp.isPresent()) {
            return policyRepo.save(policy);
        }
        else {
            throw new EntityNotFoundException();
        }
    }

    public Policy findByTitle(String title) {
        return policyRepo.findByTitle(title).get();
    }

    public boolean existsByTitle(String title) {
        return policyRepo.existsByTitle(title);
    }

}
