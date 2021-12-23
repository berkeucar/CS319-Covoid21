package com.covoid21.panman.database.repository;

import com.covoid21.panman.entity.user.User;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;

@Repository
@Transactional
public interface UserRepository{

    Optional<User> findByEmail(String email);
}
