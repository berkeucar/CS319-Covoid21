package com.covoid21.panman.database.service;

import com.covoid21.panman.database.repository.NotificationRepository;
import com.covoid21.panman.entity.Notification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificationService extends ServiceBase<Notification> {
    private NotificationRepository repo;

    @Autowired
    public NotificationService(NotificationRepository repo) {
        super();
        this.repo = repo;
        this.baseRepo = repo;
    }

    public List<Notification> findByReceiverID(Long receiverID) {
        return repo.findByReceiverID(receiverID);
    }
}
