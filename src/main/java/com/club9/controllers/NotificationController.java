package com.club9.controllers;

import com.club9.models.Member;

import java.util.List;

public class NotificationController {

    public void notifyMembers(List<Member> members) {
        for (Member member : members) {
            if (member.getMonth() != null) {
                member.sendNotification();
            }
        }
    }

}

