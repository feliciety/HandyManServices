package project.demo.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import project.demo.models.CartItem;

import java.io.IOException;

public class CartController {

    @FXML
    private AnchorPane anchorPane;

    @FXML
    private Button catalogButton;

    @FXML
    private Button checkoutButton;

    @FXML
    private TableView<CartItem> cartTable;

    @FXML
    private TableColumn<CartItem, String> productNameColumn;

    @FXML
    private TableColumn<CartItem, Double> productPriceColumn;

    @FXML
    private TableColumn<CartItem, HBox> productQuantityColumn;

    @FXML
    private TableColumn<CartItem, Double> productTotalColumn;

    @FXML
    private Label subtotalLabel;

    private ObservableList<CartItem> cartItems;

    @FXML
    public void initialize() {
        cartItems = FXCollections.observableArrayList();

        // Bind table columns to CartItem properties
        productNameColumn.setCellValueFactory(data -> data.getValue().productNameProperty());
        productPriceColumn.setCellValueFactory(data -> data.getValue().productPriceProperty().asObject());
        productTotalColumn.setCellValueFactory(data -> data.getValue().productTotalProperty().asObject());

        // Set custom cell factory for quantity column
        productQuantityColumn.setCellFactory(tc -> new TableCell<>() {
            @Override
            protected void updateItem(HBox quantityControl, boolean empty) {
                super.updateItem(quantityControl, empty);
                if (empty || quantityControl == null) {
                    setGraphic(null);
                } else {
                    setGraphic(quantityControl);
                }
            }
        });

        cartTable.setItems(cartItems);

        updateSubtotal();
    }

    public void addToCart(String productName, double price) {
        CartItem existingItem = cartItems.stream()
                .filter(item -> item.getProductName().equals(productName))
                .findFirst()
                .orElse(null);

        if (existingItem != null) {
            existingItem.setQuantity(existingItem.getQuantity() + 1);
            existingItem.updateTotal();
        } else {
            CartItem newItem = new CartItem(productName, price, 1, price, null);
            HBox quantityControl = createQuantityControl(newItem);
            newItem.setQuantityControl(quantityControl);
            cartItems.add(newItem);
        }
        cartTable.refresh();
        updateSubtotal();
    }

    private HBox createQuantityControl(CartItem cartItem) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/project/demo/fxml/QuantityControl.fxml"));
            HBox quantityControl = loader.load();
            QuantityControlController controller = loader.getController();
            controller.setQuantity(cartItem.getQuantity());
            controller.setQuantityChangeListener(newQuantity -> {
                cartItem.setQuantity(newQuantity);
                cartItem.updateTotal();
                cartTable.refresh();
                updateSubtotal();
            });
            return quantityControl;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    private void updateSubtotal() {
        double subtotal = cartItems.stream().mapToDouble(CartItem::getTotal).sum();
        subtotalLabel.setText(String.format("Subtotal: $%.2f", subtotal));
    }

    @FXML
    public void goToCatalog(ActionEvent actionEvent) {
        try {
            Stage stage = (Stage) catalogButton.getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/project/demo/fxml/ProductCatalog.fxml"));
            Scene scene = new Scene(loader.load(), 1440, 730);
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void proceedToCheckout(ActionEvent actionEvent) {
        try {
            Stage stage = (Stage) checkoutButton.getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/project/demo/fxml/CheckoutPage.fxml"));
            Scene scene = new Scene(loader.load(), 1440, 730);
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
