package com.club9.controllers;

import com.club9.models.Admin;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginController {

    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    public void login() {
        String username = usernameField.getText();
        String password = passwordField.getText();

        // Dummy admin for simplicity.
        Admin admin = new Admin("admin", "password");

        if (username.equals(admin.getUsername()) && password.equals(admin.getPassword())) {
            System.out.println("Login successful!");

            try {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/club9/home.fxml"));
                Stage stage = (Stage) usernameField.getScene().getWindow();
                stage.setScene(new Scene(fxmlLoader.load(), 800, 600));
            } catch (IOException e) {
                System.out.println("cannot redirect to home.fxml");
            }
        } else {
            System.out.println("Invalid credentials!");
        }
    }
}
