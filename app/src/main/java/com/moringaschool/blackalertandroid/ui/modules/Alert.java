package com.moringaschool.blackalertandroid.ui.modules;

public class Alert{
    private boolean alertStatus;
    private String location;

    public Alert(boolean alertStatus, String location) {
        this.alertStatus = alertStatus;
        this.location = location;
    }

    public boolean isAlertStatus() {
        return alertStatus;
    }

    public String getLocation() {
        return location;
    }
}
