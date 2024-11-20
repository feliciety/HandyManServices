package project.demo.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.geometry.*;
import javafx.scene.image.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import project.demo.models.Cart;
import project.demo.models.Product;

public class ProductCatalogController {

    @FXML
    private GridPane productGrid;

    @FXML
    private Button cartButton;

    private final Cart cart = Cart.getInstance();

    @FXML
    private void initialize() {
        // List of products with their images
        Product[] products = {
                new Product("Cordless Drill", 99.99, "resources/project/demo/images/CordlessDrill.png"),
                new Product("Hand Drill", 39.99, "resources/project/demo/images/handdrill.png"),
                new Product("Handsaw", 25.49, "resources/project/demo/images/handsaw.png"),
                new Product("Hand Vacuum", 59.99, "resources/project/demo/images/HandVacuum.png"),
                new Product("Helmet", 15.99, "resources/project.demo/images/helmet.png"),
                new Product("Metal Hand Jigsaw", 40.99, "resources/project.demo/images/metalhandjigsaw.png"),
                new Product("Metal Shovel", 22.49, "resources/project/demo/images/metalshovel.png"),
                new Product("Pipe Wrench", 18.99, "resources/project/demo/images/pipewrench.png"),
                new Product("Rubber Hand Gloves", 9.99, "resources/project/demo/images/rubberhandgloves.png"),
                new Product("Steel Hammer", 14.99, "resources/project/demo/images/steelhammer.png"),
                new Product("Steel Plier", 12.99, "resources/project/demo/images/steelplier.png"),
                new Product("Toolbox", 29.99, "resources/project/demo/images/toolbox.png")
        };

        // Populate the GridPane with product cards
        int column = 0;
        int row = 0;

        for (Product product : products) {
            VBox card = new VBox(10);
            card.setAlignment(Pos.CENTER);
            card.setPadding(new Insets(10));
            card.setStyle("-fx-border-color: #ddd; -fx-border-radius: 10px; -fx-padding: 10px;");

            // Product image
            ImageView imageView = new ImageView(new Image("file:" + product.getImagePath()));
            imageView.setFitWidth(100);
            imageView.setFitHeight(100);

            // Product name and price
            Label nameLabel = new Label(product.getName());
            nameLabel.setStyle("-fx-font-size: 16px; -fx-font-weight: bold;");
            Label priceLabel = new Label("$" + product.getPrice());
            priceLabel.setStyle("-fx-font-size: 14px;");

            // Add to Cart button
            Button addToCartButton = new Button("Add to Cart");
            addToCartButton.setOnAction(e -> addToCart(product));

            // Add components to card
            card.getChildren().addAll(imageView, nameLabel, priceLabel, addToCartButton);

            // Add card to grid
            productGrid.add(card, column, row);

            column++;
            if (column == 3) { // 3 columns per row
                column = 0;
                row++;
            }
        }
    }

    private void addToCart(Product product) {
        cart.addProduct(product);
        System.out.println("Added to cart: " + product.getName());
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
        }
    }
}