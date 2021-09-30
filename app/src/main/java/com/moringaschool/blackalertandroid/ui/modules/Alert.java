package com.moringaschool.blackalertandroid.ui.modules;

public class Alert{
    private String blackoutAlert;
    private String blackoutLocation;
    private String blackoutTime;

    public Alert(String blackoutAlert, String blackoutLocation, String blackoutTime) {
        this.blackoutAlert = blackoutAlert;
        this.blackoutLocation = blackoutLocation;
        this.blackoutTime = blackoutTime;
    }

    public String getBlackoutAlert() {
        return blackoutAlert;
    }

    public String getBlackoutLocation() {
        return blackoutLocation;
    }

    public String getBlackoutTime() {
        return blackoutTime;
    }
}
