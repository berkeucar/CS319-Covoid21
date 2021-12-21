package com.covoid21.panman.database.service;

import com.covoid21.panman.database.repository.AnnouncementRepository;
import com.covoid21.panman.entity.Announcement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class AnnouncementService {
    @Autowired
    private AnnouncementRepository repo;

    public Announcement add(Announcement announcement) {
        return repo.save(announcement);
    }
    /*
    public List<Announcement> findBySenderId(Long id) {
        return repo.findBySenderId(id);
    }
    */
    public List<Announcement> getAllAnnouncements() {
        List<Announcement> announcements = new ArrayList<Announcement>();
        repo.findAll().forEach(announcements::add);
        return announcements;
    }

}

