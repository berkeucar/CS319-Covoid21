package com.covoid21.panman.database.repository;

import com.covoid21.panman.entity.Announcement;
import com.covoid21.panman.entity.user.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface AnnouncementRepository extends CrudRepository<Announcement, Long>
{
    /**
     * Finds all announcements sent by a particular user by their University ID
     *
     * @param senderUniversityID University ID of sender
     * @return List of Announcements sent by that sender
     */
    List<Announcement> findBySenderUniversityID(int senderUniversityID);

    /**
     * Finds all announcements sent by a particular user by their instance
     * @param sender Sender
     * @return List of Announcements sent by that sender
     */
    List<Announcement> findBySender(User sender);

    /**
     * Finds an Announcement by its date
     * Date is unique, so this should return only one Announcement (or none)
     * @param date Date of Announcement
     * @return Announcement with given date (or null, if there's none)
     */
    Optional<Announcement> findByDate(Date date);
    boolean existsByDate(Date date);
}
