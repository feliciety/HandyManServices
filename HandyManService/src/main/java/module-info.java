module project.demo {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens project.demo to javafx.fxml;
    exports project.demo;
    exports project.demo.models;
    opens project.demo.models to javafx.fxml;
    exports project.demo.controllers;
    opens project.demo.controllers to javafx.fxml;
}