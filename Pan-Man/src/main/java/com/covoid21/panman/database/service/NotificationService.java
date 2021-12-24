package com.covoid21.panman.database.service;

import com.amazonaws.services.dynamodbv2.xspec.N;
import com.covoid21.panman.database.repository.NotificationRepository;
import com.covoid21.panman.entity.Notification;
import com.covoid21.panman.entity.Policy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class NotificationService extends ServiceBase<Notification> {
    private NotificationRepository notificationRepo;

    @Autowired
    public NotificationService(NotificationRepository repo) {
        super(repo);
        this.notificationRepo = repo;
    }

    public List<Notification> findByReceiverID(Long receiverID) {
        return notificationRepo.findByReceiverID(receiverID);
    }

    @Override
    public Notification save(Notification entity) {
        if (notificationRepo.existsById(entity.getId())) {
            throw new EntityExistsException();
        }
        return notificationRepo.save(entity);
    }

    @Override
    public Notification update(Notification entity) throws EntityNotFoundException {
        Optional<Notification> tmp = notificationRepo.findById(entity.getId());

        if (tmp.isPresent()) {
            return notificationRepo.save(entity);
        }
        else {
            throw new EntityNotFoundException();
        }
    }
}
