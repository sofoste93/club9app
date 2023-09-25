package com.club9.models;

public class Month {
    private String name;
    private Member assignedMember;

    public Month(String name) {
        this.name = name;
        this.assignedMember = assignedMember;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Member getAssignedMember() {
        return assignedMember;
    }

    public void setAssignedMember(Member assignedMember) {
        this.assignedMember = assignedMember;
    }

    public Month getMember() {
        return null;
    }
}
