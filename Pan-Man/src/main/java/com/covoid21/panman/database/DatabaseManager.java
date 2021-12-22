package com.covoid21.panman.database;

import com.covoid21.panman.database.service.AnnouncementService;
import com.covoid21.panman.database.service.NotificationService;
import com.covoid21.panman.entity.*;
import com.covoid21.panman.entity.appointment.Appointment;
import com.covoid21.panman.entity.user.User;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Singleton class
 */
public class DatabaseManager {
    private static DatabaseManager instance;

    // services
    @Autowired
    private AnnouncementService announcementService;
    private NotificationService notificationService;

    private DatabaseManager() {
        System.out.println("DatabaseManager() constructed");
    }

    public DatabaseManager getInstance() {
        if (instance == null) {
            instance = new DatabaseManager();
        }
        return instance;
    }

    public User getUser(Long id) {
        return null;
    }

    public Notification getNotification(Long id) {
        return notificationService.find(id);
    }

    public Course getCourse(Long id) {
        return null;
    }

    public Appointment getAppointment(Long id) {
        return null;
    }

    public TimeTable getTimeTable(Long id) {
        return null;
    }

    public Announcement getAnnouncement(Long id) {
        return announcementService.find(id);
    }

    public Policy getPolicy(int id) {
        return null;
    }
}
