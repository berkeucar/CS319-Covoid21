package com.covoid21.panman.database.service;

import com.covoid21.panman.database.repository.UserRepository;
import com.covoid21.panman.entity.Notification;
import com.covoid21.panman.entity.user.User;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UserService extends ServiceBase<User>{
    private UserRepository repo;

    @Autowired
    public UserService(UserRepository repo) {
        super();
        this.repo = repo;
        this.baseRepo = repo;
    }
}
