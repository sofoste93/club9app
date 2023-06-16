package com.club9.controllers;

// Class RegistrationController.java

import com.club9.models.User;
import com.club9.utility.FileHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.util.List;

public class RegistrationController {
    @FXML
    private TextField usernameField;
    @FXML
    private PasswordField passwordField;
    @FXML
    private Label statusText;

    @FXML
    public void onRegisterClick() {
        String username = usernameField.getText();
        String password = passwordField.getText();

        List<User> users = FileHandler.readUsers();

        for (User user : users) {
            if (user.getUsername().equals(username)) {
                // Username is already taken. Show an error message
                statusText.setText("Username is already taken");
                return;
            }
        }

        // If the method hasn't returned by now, that means the registration is successful
        FileHandler.saveUser(new User(username, password));
        statusText.setText("Registration successful");
    }
}
