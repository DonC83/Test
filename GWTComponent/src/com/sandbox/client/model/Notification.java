package com.sandbox.client.model;

public class Notification {

    private int id;

    private boolean read;

    private String message;

    private boolean isNew;

    private boolean acknowledged;

    public Notification(int id, String message) {
        this.id = id;
        this.message = message;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isRead() {
        return read;
    }

    public void setRead(boolean read) {
        this.read = read;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isNew() {
        return isNew;
    }

    public void setNew(boolean aNew) {
        isNew = aNew;
    }

    public boolean isAcknowledged() {
        return acknowledged;
    }

    public void setAcknowledged(boolean acknowledged) {
        this.acknowledged = acknowledged;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Notification) {
            Notification n = (Notification)obj;
            if (n.getMessage().equals(this.getMessage())) {
                return true;
            }
        }
        return false;
    }

}
