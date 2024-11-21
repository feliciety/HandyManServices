package project.demo.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import project.demo.models.Product;

public class ProductCardController {

    public VBox productCard;
    @FXML
    private ImageView productImage;

    @FXML
    private Label productName;

    @FXML
    private Label productPrice;

    @FXML
    private Button addToCartButton;

    private Product product;

    public void setProductData(Product product) {
        this.product = product;

        // Set product details in UI
        productName.setText(product.getName());
        productPrice.setText(String.format("$%.2f", product.getPrice()));

        // Load product image
        if (product.getImagePath() != null && !product.getImagePath().isEmpty()) {
            try {
                productImage.setImage(new Image(getClass().getResource(product.getImagePath()).toExternalForm()));
            } catch (Exception e) {
                System.err.println("Failed to load image for product: " + product.getName());
                e.printStackTrace();
            }
        } else {
            System.err.println("Image path is empty or null for product: " + product.getName());
        }
    }

    @FXML
    private void handleAddToCart() {
        System.out.println("Added to cart: " + product.getName());
        // Add your logic to add the product to the cart
    }
}
