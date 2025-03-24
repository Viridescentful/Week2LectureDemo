package com.example.localdemoenkoin;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import java.util.Locale;
import java.util.ResourceBundle;

public class HelloController {
    @FXML private Label welcomeText;
    @FXML private Button button1;
    @FXML private Button button2;
    @FXML private Button button3;

    private ResourceBundle resourceBundle;

    @FXML
    public void initialize() {
        System.out.println("Initializing Controller...");
        System.out.println("button1: " + button1); // Debugging line
        System.out.println("button2: " + button2);
        System.out.println("button3: " + button3);

        if (button1 == null || button2 == null || button3 == null) {
            System.err.println("FXML components are NOT properly injected!");
        } else {
            loadLanguage("en", "US"); // Default language
        }
    }

    private void loadLanguage(String langCode, String country) {
        Locale locale = new Locale(langCode, country);
        resourceBundle = ResourceBundle.getBundle("com.example.localdemoenkoin.bundle1", locale);

        if (button1 != null && button2 != null && button3 != null) {
            button1.setText(resourceBundle.getString("button1.text"));
            button2.setText(resourceBundle.getString("button2.text"));
            button3.setText(resourceBundle.getString("button3.text"));
            welcomeText.setText(resourceBundle.getString("label.text"));
        } else {
            System.err.println("Buttons are null! Check FXML injection.");
        }
    }

    @FXML
    protected void btnHiEn() {
        loadLanguage("en", "US"); // English
    }

    @FXML
    protected void btnMoiFi() {
        loadLanguage("sv", "SE"); // Swedish
    }

    @FXML
    protected void btnHeiSE() {
        loadLanguage("fi", "FI"); // Finnish
    }
}
