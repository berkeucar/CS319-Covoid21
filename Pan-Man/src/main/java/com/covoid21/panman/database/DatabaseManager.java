package com.covoid21.panman.database;

import com.covoid21.panman.database.repository.AnnouncementRepository;
import com.covoid21.panman.entity.*;
import com.covoid21.panman.entity.appointment.Appointment;
import com.covoid21.panman.entity.user.User;

import java.util.Optional;

/**
 * Singleton class
 */
public class DatabaseManager {
    private static DatabaseManager instance;

    private AnnouncementRepository announcementRepository;

    private DatabaseManager() {

    }

    public DatabaseManager getInstance() {
        if (instance == null) {
            instance = new DatabaseManager();
        }
        return instance;
    }

    public User getUser(int id) {
        return null;
    }

    public Notification getNotification(int id) {
        return null;
    }

    public Course getCourse(int id) {
        return null;
    }

    public Appointment getAppointment(long id) {
        return null;
    }

    public TimeTable getTimeTable(long id) {
        return null;
    }

    public Announcement getAnnouncement(long id) {
        return announcementRepository.findById(id);
    }

    public Policy getPolicy(int id) {
        return null;
    }
}
