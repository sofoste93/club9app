package com.club9.utility;

// Class FileHandler.java

import com.club9.models.User;

import java.io.*;
import java.util.*;

public class FileHandler {
    private static final String DATA_FOLDER = "data";
    private static final String USER_FILE = "userdata.txt";

    // Method to read users from the file
    public static List<User> readUsers() {
        List<User> users = new ArrayList<>();
        File file = new File(DATA_FOLDER, USER_FILE);

        // If the file doesn't exist, return an empty list
        if (!file.exists()) {
            return users;
        }

        // Otherwise, read the users from the file
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 2) {
                    users.add(new User(parts[0], parts[1]));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return users;
    }

    // Method to save a user to the file
    public static void saveUser(User user) {
        File dir = new File(DATA_FOLDER);
        // If the directory doesn't exist, create it
        if (!dir.exists()) {
            dir.mkdir();
        }

        File file = new File(dir, USER_FILE);
        try (FileWriter writer = new FileWriter(file, true)) {
            writer.write(user.getUsername() + "," + user.getPassword() + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}