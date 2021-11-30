package com.covoid21.panman.entity;

import java.util.Date;

public class Notification {
    private final int id;
    private Date date;
    private NotificationType notificationType;
    private int receiverID;
    private String message;
    private boolean isRead;

    public Notification(int id, Date date, NotificationType notificationType, int receiverID, String message, boolean isRead) {
        this.id = id;
        this.date = date;
        this.notificationType = notificationType;
        this.receiverID = receiverID;
        this.message = message;
        this.isRead = isRead;
    }
}
