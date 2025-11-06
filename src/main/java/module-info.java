module com.example.localdemoenkoin {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.localdemoenkoin to javafx.fxml;
    exports com.example.localdemoenkoin;
}