package com.club9.models;

public class Member {
    private String name;
    private boolean isAssigned;

    public Member(String name) {
        this.name = name;
        this.isAssigned = false;
    }

    public void sendNotification() {
        // Code to send an email or other type of notification
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isAssigned() {
        return isAssigned;
    }

    public void setAssigned(boolean assigned) {
        isAssigned = assigned;
    }

    public Month getMonth() {
        return this.getMonth();
    }

    public String getEmail() {
        return null;
    }

    public void setEmail(String text) {

    }
}