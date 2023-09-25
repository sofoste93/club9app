package com.club9.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Admin {
    private String username;
    private String password;
    private static List<Month> months;
    private static List<Member> members;  // Here's the change

    public Admin(String username, String password) {
        this.username = username;
        this.password = password;
        this.members = new ArrayList<>();  // Initialize the members list
        //this.months = new ArrayList<>();
        this.months.add(new Month("January"));
    }

    public static void addMember(Member member) {
        // Todo: implement the logic
    }

    public static Member getRandomMember() {
        List<Member> notAssignedMembers = members.stream()
                .filter(member -> !member.isAssigned())
                .toList();

        if (!notAssignedMembers.isEmpty()) {
            int randomIndex = new Random().nextInt(notAssignedMembers.size());
            return notAssignedMembers.get(randomIndex);
        }

        return null;
    }

    public static List<Month> getMonths() {
        return months;
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

    public static List<Member> getMembers() {
        return members;
    }

    public void setMembers(List<Member> members) {
        Admin.members = members;
    }


    public void randomizeAssignments() {
        // Your existing randomization code...

        for (Member member : members) {
            if (member.getMonth() != null) {
                member.sendNotification();
            }
        }
    }

}