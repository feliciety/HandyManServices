package project.demo.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;

public class HomePageController {

    @FXML
    private HBox header;

    @FXML
    private ScrollPane scrollPane;

    @FXML
    private AnchorPane anchorPane;

    @FXML
    public void initialize() {
        // Dynamically add the stylesheet
        if (anchorPane.getScene() != null) {
            anchorPane.getScene().getStylesheets().add(getClass().getResource("/project/demo/CSS/styles.css").toExternalForm());
        } else {
            anchorPane.sceneProperty().addListener((observable, oldScene, newScene) -> {
                if (newScene != null) {
                    newScene.getStylesheets().add(getClass().getResource("/project/demo/CSS/styles.css").toExternalForm());
                }
            });
        }
    }
}