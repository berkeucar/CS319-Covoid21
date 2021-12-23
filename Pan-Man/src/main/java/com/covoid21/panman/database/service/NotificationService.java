package com.covoid21.panman.database.service;

import com.covoid21.panman.database.repository.NotificationRepository;
import com.covoid21.panman.entity.Notification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
}
