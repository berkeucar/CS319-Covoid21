package com.covoid21.panman.database.service;

import com.covoid21.panman.database.repository.UserRepositoryBase;
import com.covoid21.panman.entity.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

public abstract class UserServiceBase<T extends User> extends ServiceBase<T> {
    private UserRepositoryBase<T> userRepo;

    @Autowired
    public UserServiceBase(UserRepositoryBase<T> repo) {
        super(repo);
        this.userRepo = repo;
    }

    @Override
    public T save(T entity) {
        if (userRepo.existsByUniversityID(entity.getUniversityID())) {
            throw new EntityExistsException();
        }
        return userRepo.save(entity);
    }

    @Override
    public T update(T entity) {
        if (!userRepo.existsByUniversityID(entity.getUniversityID())) {
            throw new EntityNotFoundException();
        }
        return userRepo.save(entity);
    }

    public T findByEmail(String email) {
        return userRepo.findByEmail(email).get();
    }

    public List<T> findByName(String name) {
        return userRepo.findByName(name);
    }

    public T findByHesCode(String hesCode) {
        return userRepo.findByHesCode(hesCode).get();
    }

    public List<T> findByCloseContactsContaining(User contact) {
        return userRepo.findByCloseContactsContaining(contact);
    }

    public List<T> findByTemporaryCloseContactsContaining(User contact) {
        return userRepo.findByTemporaryCloseContactsContaining(contact);
    }

    public T findByUniversityID(int universityID) {
        return userRepo.findByUniversityID(universityID).get();
    }

    public boolean existsByUniversityID(int universityID) {
        return userRepo.existsByUniversityID(universityID);
    }

    public T findByUserUniversityID(int universityID) {
        return userRepo.findByUserUniversityID(universityID).get();
    }

    public List<T> findByUserType(String userType) {
        return userRepo.findByUserType(userType);
    }

    public void enableUser(String email) {
        userRepo.enableUser(email);
    }

}