package com.club9.controllers;

// Class DashboardController.java

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

public class DashboardController {
    public ListView <String> memberListView;
    @FXML
    private Label welcomeText;

    public void initialize() {
        welcomeText.setText("Welcome to Club9");
    }
}