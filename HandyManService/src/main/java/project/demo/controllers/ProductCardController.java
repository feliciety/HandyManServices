package project.demo.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import project.demo.models.Cart;
import project.demo.models.Product;

public class ProductCardController {

    @FXML
    private Label productNameLabel;

    @FXML
    private Label productPriceLabel;

    @FXML
    private ImageView productImageView;

    @FXML
    private HBox quantityHBox;

    @FXML
    private Button addToCartButton;

    private final Cart cart = Cart.getInstance();

    public void setProductData(Product product) {
        try {
            productNameLabel.setText(product.getName());
            productPriceLabel.setText(String.format("$%.2f", product.getPrice()));
            productImageView.setImage(new Image(getClass().getResource(product.getImagePath()).toExternalForm()));

            // Initialize quantity control
            Button decreaseButton = new Button("-");
            Label quantityLabel = new Label("1");
            Button increaseButton = new Button("+");

            decreaseButton.setOnAction(e -> {
                int quantity = Integer.parseInt(quantityLabel.getText());
                if (quantity > 1) {
                    quantity--;
                    quantityLabel.setText(String.valueOf(quantity));
                }
            });

            increaseButton.setOnAction(e -> {
                int quantity = Integer.parseInt(quantityLabel.getText());
                quantity++;
                quantityLabel.setText(String.valueOf(quantity));
            });

            quantityHBox.getChildren().clear();
            quantityHBox.getChildren().addAll(decreaseButton, quantityLabel, increaseButton);

            addToCartButton.setOnAction(e -> {
                int quantity = Integer.parseInt(quantityLabel.getText());
                cart.addProduct(product, quantity);
                System.out.println("[DEBUG] Added to cart: " + product.getName() + ", Quantity: " + quantity);
            });

        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("[ERROR] Failed to set product data for: " + product.getName());
        }
    }
}
