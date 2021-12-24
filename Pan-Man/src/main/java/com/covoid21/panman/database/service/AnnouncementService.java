package com.covoid21.panman.database.service;

import com.covoid21.panman.database.repository.AnnouncementRepository;
import com.covoid21.panman.entity.Announcement;
import com.covoid21.panman.entity.Policy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

/**
 * Service class for Announcement entities
 * Provides most CRUD operations.
 * Used in DatabaseManager
 */

@Service
@Transactional
public class AnnouncementService extends ServiceBase<Announcement>
{
    private AnnouncementRepository announcementRepo;
    
    @Autowired
    public AnnouncementService(AnnouncementRepository repo)
    {
        super(repo);
        this.announcementRepo = repo;
    }
    
    public List<Announcement> findBySenderID(Long senderID)
    {
        return announcementRepo.findBySenderID(senderID);
    }

    @Override
    public Announcement save(Announcement entity) {
        Optional<Announcement> tmp = announcementRepo.findById(entity.getId());

        if (!tmp.isPresent()) {
            return announcementRepo.save(entity);
        }
        else {
            throw new EntityNotFoundException();
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
}

