package com.club9.controllers;

import com.club9.models.Admin;
import javafx.fxml.FXML;
import com.club9.models.Member;
import javafx.scene.control.ListView;
import javafx.scene.text.Text;


public class HomeController {

    public Text assignedMemberName;
    @FXML
        private ListView<Member> memberListView;

        private Admin admin;


    public void initialize() {
        admin = new Admin("admin", "password");
        /*assignMemberForMonth();*/
        refreshMembers();

        Member assignedMember = admin.getRandomMember(); // TODO: Replace this with real data fetching

        if (assignedMember != null) {
            assignedMemberName.setText(assignedMember.getName());
        } else {
            assignedMemberName.setText("No member assigned for this month.");
        }
    }

    /*public void assignMemberForMonth() {
        Member member = getRandomMember();
        if (member != null) {
            member.setAssigned(true);
        }
    }*/

    public void refreshMembers() {
            memberListView.getItems().setAll(admin.getMembers());
        }

        // TODO: Add methods to handle other actions (e.g. notifications, adding/deleting members, etc.)

}