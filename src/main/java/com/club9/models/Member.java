package com.club9.models;

public class Member {
    private String name;
    private boolean isAssigned;

    public Member(String name) {
        this.name = name;
        this.isAssigned = false;
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
}