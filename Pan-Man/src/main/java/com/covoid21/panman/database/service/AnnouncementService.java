package com.covoid21.panman.database.service;

import com.covoid21.panman.database.repository.AnnouncementRepository;
import com.covoid21.panman.entity.Announcement;
import com.covoid21.panman.entity.Policy;
import com.covoid21.panman.entity.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * Service class for Announcement entities
 * Provides most CRUD operations.
 * Used in DatabaseManager
 */

@Service
@Transactional
public class AnnouncementService extends ServiceBase<Announcement> {
    private AnnouncementRepository announcementRepo;
    
    @Autowired
    public AnnouncementService(AnnouncementRepository repo) {
        super(repo);
        this.announcementRepo = repo;
    }

    @Override
    public Announcement save(Announcement entity) {
        if (announcementRepo.existsById(entity.getId()) || announcementRepo.existsByDate(entity.getDate())) {
            throw new EntityExistsException();
        }
        else {
            return announcementRepo.save(entity);
        }
    }

    @Override
    public Announcement update(Announcement entity) throws EntityNotFoundException {
        Optional<Announcement> tmp = announcementRepo.findById(entity.getId());

        if (tmp.isPresent()) {
            return announcementRepo.save(entity);
        }
        else {
            throw new EntityNotFoundException();
        }
    }

    public List<Announcement> findBySenderUniversityID(int senderID) {
        return announcementRepo.findBySenderUniversityID(senderID);
    }

    public List<Announcement> findBySender(User sender) {
        return announcementRepo.findBySender(sender);
    }

    public Announcement findByDate(Date date) {
        return announcementRepo.findByDate(date).get();
    }

    public boolean existsByDate(Date date) {
        return announcementRepo.existsByDate(date);
    }
}

