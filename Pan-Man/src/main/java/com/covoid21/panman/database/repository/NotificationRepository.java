package com.covoid21.panman.database.repository;

import com.covoid21.panman.entity.Notification;
import com.covoid21.panman.entity.user.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NotificationRepository extends CrudRepository<Notification, Long>
{
    /**
     * Finds all notifications of a user by their ID
     *
     * @param receiver Receiver user
     * @return List of Notifications sent to that receiver
     */
    List<Notification> findByReceiver(User receiver);
}
