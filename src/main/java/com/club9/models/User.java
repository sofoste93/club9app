package com.club9.models;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable {
    private String username;
    private String password;
    private String editedBy;
    private Date editDate;
    private String name;
    private double amount;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public User() {
        // default constructor
    }
    @Override
    public String toString() {
        return username;
    }

    public String getEditedBy() {
        return editedBy;
    }

    public void setEditedBy(String editedBy) {
        this.editedBy = editedBy;
    }

    public Date getEditDate() {
        return editDate;
    }

    public void setEditDate(Date editDate) {
        this.editDate = editDate;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
