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

    private String currentPage = ""; // Track the currently loaded page

    private void loadPage(String fxmlFile) {
        if (currentPage.equals(fxmlFile)) {
            System.out.println("Page already loaded: " + fxmlFile);
            return; // Prevent reloading the same page
        }

        try {
            System.out.println("Loading FXML: " + fxmlFile);
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlFile));
            AnchorPane newPage = loader.load();
            scrollPane.setContent(newPage);
            currentPage = fxmlFile; // Update the currently loaded page
            System.out.println("Successfully loaded: " + fxmlFile);
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Failed to load page: " + fxmlFile);
        }
    }

    @FXML
    private void initialize() {
        loadPage("/project/demo/fxml/HomePage.fxml");
    }

    @FXML
    private void handleHomeClick() {
        loadPage("/project/demo/fxml/HomePage.fxml");
    }

    @FXML
    public void handleShopClick(ActionEvent actionEvent) {
        loadPage("/project/demo/fxml/ProductCatalog.fxml");
    }

    @FXML
    public void handleCartClick(ActionEvent actionEvent) {
        loadPage("/project/demo/fxml/CartPage.fxml");
    }

    @FXML
    public void handleCheckoutClick(ActionEvent actionEvent) {
        loadPage("/project/demo/fxml/CheckoutPage.fxml");
    }

    @FXML
    public void handleBookServiceClick(ActionEvent actionEvent) {
        loadPage("/project/demo/fxml/BookService.fxml");
    }
}
