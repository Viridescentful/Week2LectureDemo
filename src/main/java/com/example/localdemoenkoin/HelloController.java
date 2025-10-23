package com.example.localdemoenkoin;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.ZoneId;
import java.util.Locale;
import java.util.ResourceBundle;

public class HelloController {
    @FXML private Label welcomeText;
    @FXML private Button button1;
    @FXML private Button button2;
    @FXML private Button button3;
    @FXML private Button button4;
    @FXML private Label timeLabel; // New label for showing time

    private ResourceBundle resourceBundle;

    @FXML
    public void initialize() {
        System.out.println("Initializing Controller...");
        if (button1 == null || button2 == null || button3 == null) {
            System.err.println("FXML components are NOT properly injected!");
        } else {
            loadLanguage("en", "US"); // Default language
        }
    }

    private void loadLanguage(String langCode, String country) {
        Locale locale = new Locale(langCode, country);
        resourceBundle = ResourceBundle.getBundle("com.example.localdemoenkoin.bundle1", locale);

        if (button1 != null && button2 != null && button3 != null && button4 != null && timeLabel != null) {
            button1.setText(resourceBundle.getString("button1.text"));
            button2.setText(resourceBundle.getString("button2.text"));
            button3.setText(resourceBundle.getString("button3.text"));
            button4.setText(resourceBundle.getString("button4.text"));
            welcomeText.setText(resourceBundle.getString("label.text"));

            // Show the current time for the selected region
            updateTimeForLocale(langCode, country);
        } else {
            System.err.println("FXML injection issue detected!");
        }
    }
// Final topic
    private void updateTimeForLocale(String langCode, String country) {
        String zoneId;

        // Set ZoneId based on the selected country
        switch (country) {
            case "FI" -> zoneId = "Europe/Helsinki";
            case "SE" -> zoneId = "Europe/Stockholm";
            case "IR" -> zoneId = "Asia/Tehran";
            case "US" -> zoneId = "America/New_York";
            default -> zoneId = "UTC";
        }

        ZonedDateTime zonedDateTime = ZonedDateTime.now(ZoneId.of(zoneId));
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss - zzzz", Locale.ENGLISH);
        timeLabel.setText("Current time in " + zoneId + ": " + zonedDateTime.format(formatter));
    }

    @FXML
    protected void btnHiEn() {
        loadLanguage("en", "US"); // English
    }

    @FXML
    protected void btnMoiFi() {
        loadLanguage("fi", "FI"); // Finnish
    }

    @FXML
    protected void btnHeiSE() {
        loadLanguage("sv", "SE"); // Swedish
    }

    @FXML
    protected void bntSalamPer(ActionEvent actionEvent) {
        loadLanguage("fa", "IR"); // Persian
    }
}
