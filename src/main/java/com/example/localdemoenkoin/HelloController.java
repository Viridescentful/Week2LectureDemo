package com.example.localdemoenkoin;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.ZoneId;
import java.util.Locale;
import java.util.ResourceBundle;

public class HelloController {

    @FXML private Button button1;
    @FXML private Button button2;
    @FXML private Button button3;
    @FXML private Button button4;
    @FXML private Button button5;

    @FXML private Button calculatebutton;

    @FXML private Text resultfield;
    @FXML private TextField heightfield;
    @FXML private TextField weightfield;

    @FXML private Text heighttext;
    @FXML private Text weighttext;

    private ResourceBundle resourceBundle;

    @FXML
    public void initialize() {
        System.out.println("Initializing Controller...");

        if (button1 == null || button2 == null || button3 == null) {
            System.err.println("FXML components are NOT properly injected!");
        } else {
            loadLanguage("en", "US");
        }
    }

    private void loadLanguage(String langCode, String country) {
        Locale locale = new Locale(langCode, country);
        resourceBundle = ResourceBundle.getBundle("com.example.localdemoenkoin.bundle1", locale);

        if (button1 != null && button2 != null && button3 != null && button4 != null) {
            button1.setText(resourceBundle.getString("button1.text"));
            button2.setText(resourceBundle.getString("button2.text"));
            button3.setText(resourceBundle.getString("button3.text"));
            button4.setText(resourceBundle.getString("button4.text"));
            button5.setText(resourceBundle.getString("button5.text"));

            calculatebutton.setText(resourceBundle.getString("calculatebutton.text"));
            heighttext.setText(resourceBundle.getString("heighttext.text"));
            weighttext.setText(resourceBundle.getString("weighttext.text"));

            resultfield.setText(resourceBundle.getString("resultfield.text"));



            if (langCode.equals("fa")) {
               resultfield.setNodeOrientation(javafx.geometry.NodeOrientation.RIGHT_TO_LEFT);
            } else {
                resultfield.setNodeOrientation(javafx.geometry.NodeOrientation.LEFT_TO_RIGHT);
            }

        } else {
            System.err.println("FXML injection issue detected!");
        }
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

    @FXML
    protected void bntBonjourFR(ActionEvent actionEvent) {
        loadLanguage("fr", "FR"); // French
    }

    @FXML
    protected void onCalculate() {
        double height = Double.parseDouble(heightfield.getText());
        double weight = Double.parseDouble(weightfield.getText());
        double bmi = BMICalculator.calculateBMI(weight, height);

        resultfield.setText(resourceBundle.getString("resultfield.text") + " " + String.valueOf(bmi));
    }
}
