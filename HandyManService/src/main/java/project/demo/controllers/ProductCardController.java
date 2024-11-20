package project.demo.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import project.demo.models.Cart;
import project.demo.models.Product;

public class ProductCardController {

    @FXML
    private ImageView productImage;

    @FXML
    private Label productName;

    @FXML
    private Label productPrice;

    @FXML
    private Button addToCartButton;

    private final Cart cart = Cart.getInstance();
    private Product product;

    /**
     * Sets the data for this product card.
     *
     * @param product The product to display
     */
    public void setProductData(Product product) {
        this.product = product;
        productName.setText(product.getName());
        productPrice.setText("$" + String.format("%.2f", product.getPrice()));
        productImage.setImage(new Image("file:" + product.getImagePath()));
        addToCartButton.setOnAction(e -> {
            cart.addProduct(product);
            System.out.println(product.getName() + " added to cart!");
        });
    }
}
