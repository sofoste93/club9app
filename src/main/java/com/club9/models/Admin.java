package com.club9.models;

public class Admin extends User {
    private String pin;

    private final String secretWord = "club9";

    public Admin(String username, String password) {
        super(username, password);
    }

    public String getSecretWord() {
        return secretWord;
    }
    public Admin() {

    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }
}
