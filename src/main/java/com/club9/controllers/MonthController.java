package com.club9.controllers;

import com.club9.models.Member;
import com.club9.models.Admin;
import com.club9.models.Month;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.text.Text;

import java.util.ArrayList;
import java.util.List;

public class MonthController {

    public ListView<String> monthListView;
    @FXML
    private Text memberNameLabel;

    public void initialize() {

        List<Month> months = Admin.getMonths();

        for (Month month : months) {
            String text = month.getName() + ": " + (month.getMember() != null ? month.getMember().getName() : "Not assigned");
            monthListView.getItems().add(text);
        }
    }

    public void refresh() {
        // This is just a simple example. You will need to replace the ArrayList with the actual list of months.
        List<Month> months = new ArrayList<>(); // Replace this with your actual data

        monthListView.getItems().clear();
        monthListView.getItems().addAll(String.valueOf(months));
    }
}
