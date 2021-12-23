package com.covoid21.panman.database.service;

import com.covoid21.panman.database.repository.UserRepositoryBase;
import com.covoid21.panman.entity.user.User;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public abstract class UserServiceBase<T extends User> extends ServiceBase<T> {
    private UserRepositoryBase<T> userRepo;

    @Autowired
    public UserServiceBase(UserRepositoryBase<T> repo)
    {
        super(repo);
        this.userRepo = repo;
    }

    /*
    @Override
    public T save(T user) {
        if (user.getEmail())
    }
     */

    public T findByEmail(String email) {
        return userRepo.findByEmail(email).get();
    }

    public T findByName(String name) {
        return userRepo.findByName(name).get();
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
    /*
    public T findByUniversityID(int universityID) {
        return userRepo.findByUniversityID(universityID).get();
    }
    */
}
