package com.covoid21.panman.database.repository;

import com.covoid21.panman.entity.Announcement;
import com.covoid21.panman.entity.Notification;
import com.covoid21.panman.entity.user.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

}
