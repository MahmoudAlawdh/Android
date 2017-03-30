package com.example.mhd.donor;

/**
 * Created by mhd on 3/30/17.
 */

public class NotificationModel {
    private String date;
    private String description;
    private int notifId;
    private int status;
    private String title;

    public NotificationModel(String date, String description, int notifId, int status, String title) {
        this.setDate(date);
        this.setDescription(description);
        this.setNotifId(notifId);
        this.setStatus(status);
        this.setTitle(title);
    }



    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getNotifId() {
        return notifId;
    }

    public void setNotifId(int notifId) {
        this.notifId = notifId;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
