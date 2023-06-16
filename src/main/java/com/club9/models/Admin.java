package com.club9.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Admin {
    private String username;
    private String password;
    private List<Member> members;  // Here's the change

    public Admin(String username, String password) {
        this.username = username;
        this.password = password;
        this.members = new ArrayList<>();  // Initialize the members list
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Member> getMembers() {
        return members;
    }

    public void setMembers(List<Member> members) {
        this.members = members;
    }

    public Member getRandomMember() {
        List<Member> notAssignedMembers = members.stream()
                .filter(member -> !member.isAssigned())
                .collect(Collectors.toList());

        if (!notAssignedMembers.isEmpty()) {
            int randomIndex = new Random().nextInt(notAssignedMembers.size());
            return notAssignedMembers.get(randomIndex);
        }

        return null;
    }
}