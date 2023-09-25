package com.club9.controllers;

import com.club9.models.Admin;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import com.club9.models.Member;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.TableView;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;


public class HomeController {

    private MemberController memberController;
    private MonthController monthController;
    private NotificationController notificationController;
    public Text assignedMemberName;
    @FXML
    private ListView<Member> memberListView;
    @FXML
    private TableView tableView;
    private Admin admin;


    public void initialize() {
        admin = new Admin("admin", "password");
        refreshMembers();

        Member assignedMember = admin.getRandomMember(); // TODO: Replace this with real data fetching

        if (assignedMember != null) {
            assignedMemberName.setText(assignedMember.getName());
        } else {
            assignedMemberName.setText("No member assigned for this month.");
        }
    }

    @FXML
    public void randomize() {
        admin.randomizeAssignments();
        notificationController.notifyMembers(admin.getMembers());
        refresh();
    }

    public void refresh() {
        memberController.refresh();
        monthController.refresh();
    }

    public void refreshMembers() {
        memberListView.getItems().setAll(admin.getMembers());
    }

    @FXML
    public void showMember() {
        try {
            Member member = (Member) tableView.getSelectionModel().getSelectedItem(); // Get the selected member
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/club9/member.fxml"));
            Stage stage = (Stage) tableView.getScene().getWindow();
            stage.setScene(new Scene(fxmlLoader.load(), 800, 600));
            MemberController memberController = fxmlLoader.getController(); // Get the controller of the member view
            memberController.setMember(member); // Set the member of the controller
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}