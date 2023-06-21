package com.club9.controllers;


import com.club9.models.Contribution;
import com.club9.models.*;
import com.club9.utility.FileHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.ComboBox;

public class ContributionController {
    private static final double EXCHANGE_RATE = 656.55; // 1 EUR = 656.55 XAF

    @FXML
    private TextField amountField;

    @FXML
    private ComboBox<String> currencyComboBox;

    @FXML
    private Label statusText;

    @FXML
    public void initialize() {
        currencyComboBox.getItems().addAll("EUR", "XAF");
        currencyComboBox.setValue("XAF");
    }

    @FXML
    public void onContributeClick() {
        double amount = Double.parseDouble(amountField.getText());
        String currency = currencyComboBox.getValue();

        if (currency.equals("EUR")) {
            amount *= EXCHANGE_RATE; // convert to XAF
        }

        if (amount < 10500) {
            statusText.setText("Minimum contribution is 10500 XAF");
            return;
        }

        // Add the contribution
        User user = SessionManager.getCurrentUser();
        Contribution contribution = new Contribution(user, amount);
        FileHandler.saveContribution(contribution);

        statusText.setText("Contribution added successfully");
    }
}


