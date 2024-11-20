package project.demo.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class MainController {

    @FXML
    private ScrollPane scrollPane;

    private void loadPage(String fxmlFile) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlFile));
            AnchorPane newPage = loader.load();
            scrollPane.setContent(newPage);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Failed to load page: " + fxmlFile);
        }
    }

    @FXML
    private void initialize() {
        loadPage("/project/demo/fxml/HomePage.fxml");
    }

    @FXML
    private void handleHomeClick() {
        loadPage("/project/demo/FXML/HomePage.fxml");
    }

    public void handleAboutUsClick(ActionEvent actionEvent) {
    }

    public void handleShopClick(ActionEvent actionEvent) {
    }

    public void handleServiceClick(ActionEvent actionEvent) {
    }

    public void handleBookServiceClick(ActionEvent actionEvent) {
    }
}
