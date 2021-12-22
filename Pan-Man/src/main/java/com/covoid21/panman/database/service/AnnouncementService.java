package com.covoid21.panman.database.service;

import com.covoid21.panman.database.repository.AnnouncementRepository;
import com.covoid21.panman.entity.Announcement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service class for Announcement entities
 * Provides most CRUD operations.
 * Used in DatabaseManager
 */

@Service
public class AnnouncementService extends ServiceBase<Announcement> {

    private AnnouncementRepository repo;

    @Autowired
    public AnnouncementService(AnnouncementRepository repo) {
        super();
        this.repo = repo;
        this.baseRepo = repo;
    }

    public List<Announcement> findBySenderID(Long senderID) {
        return repo.findBySenderID(senderID);
    }

}

