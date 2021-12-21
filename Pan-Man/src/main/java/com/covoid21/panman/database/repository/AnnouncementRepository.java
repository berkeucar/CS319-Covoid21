package com.covoid21.panman.database.repository;

import com.covoid21.panman.entity.Announcement;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnnouncementRepository extends CrudRepository<Announcement, Long> {
    //Announcement findById(long id);
}
