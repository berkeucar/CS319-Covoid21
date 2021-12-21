package com.covoid21.panman.database.repository;

import com.covoid21.panman.entity.Announcement;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface AnnouncementRepository extends CrudRepository<Announcement, Long> {
    //List<Announcement> findBySenderId(long senderId);
}
