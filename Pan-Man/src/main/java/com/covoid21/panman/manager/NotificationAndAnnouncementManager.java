package com.covoid21.panman.manager;

import com.covoid21.panman.entity.NotificationType;

import java.util.ArrayList;
import java.util.Date;

public class NotificationAndAnnouncementManager {
    private NotificationAndAnnouncementManager instance;

    private NotificationAndAnnouncementManager() {

    }

    public NotificationAndAnnouncementManager getInstance() {
        return instance;
    }

    public void showNotificationsScreen(int userId, NotificationType notificationType) {

    }

    public void showAnnouncementsScreen() {

    }

    public void sendNotification(int targetUserID, NotificationType notificationType, ArrayList<Integer> usersID, int courseID, int appointmentID) {

    }

    public void sendAnnouncement(String message, Date date, int senderID) {

    }

    /*
    private ? nearAppointment(id userID, LocalTime remainingTime) {

    }
     */

    public void sendNotificationToUserContacts(int userID) {

    }
}
