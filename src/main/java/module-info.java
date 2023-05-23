module com.example.calorietracker {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.datatransfer;


    opens com.example.calorietracker to javafx.fxml;
    exports com.example.calorietracker;
    exports com.example.calorietracker.Controllers;
    opens com.example.calorietracker.Controllers to javafx.fxml;
}