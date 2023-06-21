package com.club9.controllers;

import com.club9.models.*;
import com.club9.utility.FileHandler;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.*;

public class LoginController {
    @FXML
    public TextField usernameField;
    @FXML
    private PasswordField passwordField;
    @FXML
    private Label statusText;

    @FXML
    public void onLoginClick(ActionEvent event) {
        String username = usernameField.getText();
        String password = passwordField.getText();

        List<User> users = FileHandler.readUsers();

        for (User user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                // Login successful. Set current user and navigate to Dashboard.
                SessionManager.setCurrentUser(user);

                try {
                    // Get the current stage
                    Node node = (Node) event.getSource();
                    Stage stage = (Stage) node.getScene().getWindow();

                    // Load the new scene
                    Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/club9/Dashboard.fxml")));
                    Scene scene = new Scene(root, 800, 600);

                    // Set the new scene to the stage
                    stage.setScene(scene);
                } catch (IOException e) {
                    e.printStackTrace();
                }

                return;
            }
        }

        // If the method hasn't returned by now, that means the login was unsuccessful
        statusText.setText("Invalid username or password");
    }
}