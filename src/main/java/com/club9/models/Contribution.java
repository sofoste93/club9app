package com.club9.models;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Contribution {
    private User user;
    private double amount;
    private LocalDateTime contributionDate;

    // Constructor without date (uses current date)
    public Contribution(User user, double amount) {
        this(user, amount, LocalDateTime.now());
    }

    // Constructor with date
    public Contribution(User user, double amount, LocalDateTime date) {
        this.user = user;
        this.amount = amount;
        this.contributionDate = date;
    }
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public LocalDateTime getContributionDate() {
        return contributionDate;
    }
    public String getFormattedContributionDate() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        return this.contributionDate.format(formatter);
    }

    public void setContributionDate(LocalDateTime contributionDate) {
        this.contributionDate = contributionDate;
    }
}
