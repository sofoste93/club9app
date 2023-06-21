package com.club9.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

public class DashboardController {
    @FXML
    public ListView <String> memberListView;
    @FXML
    private Label welcomeText;

    public void initialize() {
        welcomeText.setText("Hello, welcome back!");
    }
}