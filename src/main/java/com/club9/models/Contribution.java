package com.club9.models;

import java.time.LocalDateTime;

public class Contribution {
    private User user;
    private double amount;
    private LocalDateTime date;

    public Contribution(User user, double amount) {
        this.user = user;
        this.amount = amount;
        this.date = LocalDateTime.now();
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

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }
}
