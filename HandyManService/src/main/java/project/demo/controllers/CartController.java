package project.demo.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import project.demo.models.Cart;
import project.demo.models.Product;

public class CartController {

    @FXML
    private TableView<Product> cartTable;

    @FXML
    private TableColumn<Product, String> productNameColumn;

    @FXML
    private TableColumn<Product, Double> productPriceColumn;

    @FXML
    private Button checkoutButton;

    private final Cart cart = Cart.getInstance();

    @FXML
    private void initialize() {
        productNameColumn.setCellValueFactory(data -> data.getValue().nameProperty());
        productPriceColumn.setCellValueFactory(data -> data.getValue().priceProperty().asObject());
        cartTable.setItems(cart.getProducts());
    }

    @FXML
    private void goToCheckout(ActionEvent actionEvent) {
        try {
            Stage stage = (Stage) checkoutButton.getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/CheckoutPage.fxml"));
            Scene scene = new Scene(loader.load(), 1440, 730);
            stage.setScene(scene);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void goToCatalog(ActionEvent actionEvent) {
        try {
            Stage stage = (Stage) cartTable.getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/ProductCatalog.fxml"));
            Scene scene = new Scene(loader.load(), 1440, 730);
            stage.setScene(scene);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void proceedToCheckout(ActionEvent actionEvent) {
        // Optional logic to handle proceeding to checkout
        goToCheckout(actionEvent);  // Example of calling goToCheckout
    }
}
