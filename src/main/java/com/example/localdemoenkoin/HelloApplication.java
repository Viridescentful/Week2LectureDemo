package com.example.localdemoenkoin;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ResourceBundle;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
       FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("hello-view.fxml"));
        loader.setResources(ResourceBundle.getBundle("bundle1"));
        Parent root = loader.load();
        //Scene scene = new Scene(fxmlLoader.load());
        stage.setScene(new Scene (root));
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}