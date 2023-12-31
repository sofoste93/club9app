package com.club9.controllers;

import com.club9.models.*;
import com.club9.utility.FileHandler;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import java.util.Comparator;
import java.util.List;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;

public class MemberInfoController {
    private static final double EXCHANGE_RATE = 656.55; // 1 EUR = 656.55 XAF

    @FXML
    private TableView<Contribution> tableView;

    @FXML
    private TableColumn<Contribution, String> userColumn;

    @FXML
    private TableColumn<Contribution, String> amountColumn;

    @FXML
    private TableColumn<Contribution, String> dateColumn;

    public void initialize() {

        List<Contribution> contributions = FileHandler.readContributions();

        // Sort the contributions by date
        contributions.sort(Comparator.comparing(Contribution::getContributionDate));

        ObservableList<Contribution> data = FXCollections.observableArrayList(contributions);

        userColumn.setCellValueFactory(new PropertyValueFactory<>("user"));
        amountColumn.setCellValueFactory(new PropertyValueFactory<>("amount"));
        dateColumn.setCellValueFactory(new PropertyValueFactory<>("formattedContributionDate"));

        tableView.setItems(data);

    }

    public void gotoDashboard(ActionEvent actionEvent) {

    }
}


