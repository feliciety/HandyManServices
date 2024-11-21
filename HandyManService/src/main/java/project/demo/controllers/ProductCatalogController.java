package project.demo.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import project.demo.models.Cart;
import project.demo.models.Product;

import java.io.IOException;

public class ProductCatalogController {

    @FXML
    private GridPane productGrid;

    @FXML
    private VBox productTemplate; // Template VBox defined in FXML

    @FXML
    private Button cartButton;

    private final Cart cart = Cart.getInstance();

    @FXML
    private AnchorPane anchorPane;

    @FXML
    private void initialize() {
        System.out.println("[DEBUG] Initializing Product Catalog...");

        // Apply stylesheet dynamically
        if (anchorPane != null && anchorPane.getScene() != null) {
            anchorPane.getScene().getStylesheets().add(getClass().getResource("/project/demo/CSS/styles.css").toExternalForm());
        } else if (anchorPane != null) {
            anchorPane.sceneProperty().addListener((observable, oldScene, newScene) -> {
                if (newScene != null) {
                    newScene.getStylesheets().add(getClass().getResource("/project/demo/CSS/styles.css").toExternalForm());
                }
            });
        }

        // List of products
        Product[] products = {
                new Product("Cordless Drill", 99.99, "/project/demo/images/CordlessDrill.png"),
                new Product("Hand Drill", 39.99, "/project/demo/images/handdrill.png"),
                new Product("Handsaw", 25.49, "/project/demo/images/handsaw.png"),
                new Product("Hand Vacuum", 59.99, "/project/demo/images/HandVacuum.png"),
                new Product("Helmet", 15.99, "/project/demo/images/helmet.png"),
                new Product("Metal Hand Jigsaw", 40.99, "/project/demo/images/metalhandjigsaw.png"),
                new Product("Metal Shovel", 22.49, "/project/demo/images/metalshovel.png"),
                new Product("Pipe Wrench", 18.99, "/project/demo/images/pipewrench.png"),
                new Product("Rubber Hand Gloves", 9.99, "/project/demo/images/rubberhandgloves.png"),
                new Product("Steel Hammer", 14.99, "/project/demo/images/steelhammer.png"),
                new Product("Steel Plier", 12.99, "/project/demo/images/steelplier.png"),
                new Product("Toolbox", 29.99, "/project/demo/images/toolbox.png")
        };

        // Clear the default template from the GridPane
        if (productTemplate != null) {
            productGrid.getChildren().remove(productTemplate);
        }

        // Populate the GridPane with product data
        int column = 0;
        int row = 0;

        for (Product product : products) {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/project/demo/fxml/ProductCard.fxml"));
                VBox productCard = loader.load();

                // Set product data in the controller
                ProductCardController cardController = loader.getController();
                cardController.setProductData(product);

                // Add to the grid
                productGrid.add(productCard, column, row);

                System.out.println("[DEBUG] Added product to grid: " + product.getName());

                column++;
                if (column == 3) { // 3 columns per row
                    column = 0;
                    row++;
                }
            } catch (IOException e) {
                e.printStackTrace();
                System.err.println("[ERROR] Failed to load product card for: " + product.getName());
            }
        }
    }

    @FXML
    private void goToCart() {
        try {
            Stage stage = (Stage) cartButton.getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/project/demo/fxml/CartPage.fxml"));
            Scene scene = new Scene(loader.load(), 1440, 730);
            stage.setScene(scene);
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("[ERROR] Failed to navigate to cart.");
        }
    }
}
