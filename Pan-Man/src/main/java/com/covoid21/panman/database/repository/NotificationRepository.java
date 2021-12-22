package com.covoid21.panman.database.repository;

import com.covoid21.panman.entity.Notification;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NotificationRepository extends CrudRepository<Notification, Long>
{
    /**
     * Finds all notifications of a user by ider
     *
     * @param receiverID ID of sender (can be also null, in which case
     *                 the method fetches all anonymous announcements)
     * @return List of Notifications sent to that receiver
     */
    List<Notification> findByReceiverID(Long receiverID);
}
