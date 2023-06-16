// Class LoginController.java

package com.club9.controllers;

import com.club9.models.User;
import com.club9.utility.FileHandler;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;
import java.util.Objects;

public class LoginController {
    @FXML
    private TextField usernameField;
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
                // Login successful. Navigate to Dashboard.
                try {
                    // Get the current stage
                    Node node = (Node) event.getSource();
                    Stage stage = (Stage) node.getScene().getWindow();

                    // Load the new scene
                    Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/club9/Dashboard.fxml")));
                    Scene scene = new Scene(root);

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