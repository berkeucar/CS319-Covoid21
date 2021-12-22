package com.covoid21.panman.database.repository;

import com.covoid21.panman.entity.Announcement;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnnouncementRepository extends CrudRepository<Announcement, Long>
{
    /**
     * Finds all announcements sent by a particular user
     *
     * @param senderID ID of sender (can be also null, in which case
     *                 the method fetches all anonymous announcements)
     * @return List of Announcements sent by that sender
     */
    List<Announcement> findBySenderID(Long senderID);
}