package project.demo.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.fxml.FXMLLoader;
import project.demo.models.Cart;
import project.demo.models.Product;

public class CheckoutController {

    @FXML
    private TableView<Product> checkoutTable;

    @FXML
    private TableColumn<Product, String> productNameColumn;

    @FXML
    private TableColumn<Product, Double> productPriceColumn;

    @FXML
    private Label totalAmountLabel;

    @FXML
    private Button finalizeOrderButton;

    private final Cart cart = Cart.getInstance();

    @FXML
    private void initialize() {
        productNameColumn.setCellValueFactory(data -> data.getValue().nameProperty());
        productPriceColumn.setCellValueFactory(data -> data.getValue().priceProperty().asObject());
        checkoutTable.setItems(cart.getProducts());
        updateTotalAmount();
    }

    private void updateTotalAmount() {
        double total = cart.getProducts().stream().mapToDouble(Product::getPrice).sum();
        totalAmountLabel.setText("Total: $" + String.format("%.2f", total));
    }

    @FXML
    private void finalizeOrder() {
        cart.clear();
        Alert alert = new Alert(Alert.AlertType.INFORMATION, "Order placed successfully!", ButtonType.OK);
        alert.showAndWait();
        goToProductCatalog();
    }

    private void goToProductCatalog() {
        try {
            Stage stage = (Stage) finalizeOrderButton.getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/project/demo/fxml/ProductCatalog.fxml"));
            Scene scene = new Scene(loader.load(), 1440, 730);
            stage.setScene(scene);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void confirmCheckout(ActionEvent actionEvent) {
    }

    public void goBackToCart(ActionEvent actionEvent) {
    }
}
