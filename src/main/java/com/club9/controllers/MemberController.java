package com.club9.controllers;

import com.club9.models.Member;
import com.club9.models.Admin;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MemberController {

    @FXML
    public ListView<String> memberListView;
    private List<Member> members = new ArrayList<>();
    @FXML
    private TextField nameField;
    @FXML
    private Text messageLabel;
    private TextField emailField;


    public List<Member> getMembers() {
        return members;
    }

    public void addMember(Member member) {
        this.members.add(member);
    }
    @FXML
    public void addMember() {
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Add Member");
        dialog.setHeaderText("Enter member's name:");

        Optional<String> result = dialog.showAndWait();

        result.ifPresent(name -> {
            Member newMember = new Member(name);
            // TODO: Replace with real implementation
            Admin.addMember(newMember);
            memberListView.getItems().add(newMember.getName());
        });
    }

    public void refresh() {
        // This is just a simple example.
        List<Member> members = new ArrayList<>(); // Replace this with your actual data

        memberListView.getItems().clear();
        memberListView.getItems().addAll(String.valueOf(members));
    }

    private Member member; // the member currently being viewed or edited

    // Set the member and update the text fields
    public void setMember(Member member) {
        this.member = member;
        nameField.setText(member.getName());
        emailField.setText(member.getEmail());
    }

    // Save the changes made to the member
    @FXML
    public void save() {
        member.setName(nameField.getText());
        member.setEmail(emailField.getText());
        // Save the changes to the database or other persistent storage here
    }

    // Go back to the home page
    @FXML
    public void back(MouseEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/club9/home.fxml"));
            Stage stage = (Stage) nameField.getScene().getWindow();
            stage.setScene(new Scene(fxmlLoader.load(), 800, 600));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
