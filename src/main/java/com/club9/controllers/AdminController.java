package com.club9.controllers;

import com.club9.models.*;
import com.club9.utility.FileHandler;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.util.Date;
import java.util.Random;

public class AdminController {
    @FXML
    private TextField usernameField, pinField, secretWordField;

    public void generateCredentials() {
        if (!"club9".equals(secretWordField.getText())) {
            // Invalid secret word
            return;
        }
        String username = generateUsername();
        String pin = generatePin();

        Admin admin = new Admin();
        admin.setUsername(username);
        admin.setPin(pin);

        // Save admin to the database
        FileHandler.saveAdmin(admin);

        usernameField.setText(username);
        pinField.setText(pin);
    }

    public void updateUser(User user, String name, double amount) {
        user.setName(name);
        user.setAmount(amount);
        user.setEditedBy(SessionManager.getCurrentUser().getUsername());
        user.setEditDate(new Date());

        // Save changes to the database
        FileHandler.saveUser(user);
    }

    private String generateUsername() {
        Random random = new Random();
        return "admin" + random.nextInt(1000); // This will generate usernames like 'admin123', 'admin847', etc.
    }

    private String generatePin() {
        Random random = new Random();
        return String.format("%04d", random.nextInt(10000)); // This will generate a random 4-digit pin
    }

}

