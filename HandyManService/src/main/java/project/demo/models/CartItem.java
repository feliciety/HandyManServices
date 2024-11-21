package project.demo.models;

import javafx.beans.property.*;

import javafx.scene.layout.HBox;

public class CartItem {

    private final StringProperty productName;
    private final DoubleProperty productPrice;
    private final IntegerProperty quantity;
    private final DoubleProperty totalPrice;
    private final HBox quantityControl;

    public CartItem(String productName, double productPrice, int quantity, double totalPrice, HBox quantityControl) {
        this.productName = new SimpleStringProperty(productName);
        this.productPrice = new SimpleDoubleProperty(productPrice);
        this.quantity = new SimpleIntegerProperty(quantity);
        this.totalPrice = new SimpleDoubleProperty(totalPrice);
        this.quantityControl = quantityControl;
    }

    public String getProductName() {
        return productName.get();
    }

    public StringProperty productNameProperty() {
        return productName;
    }

    public double getProductPrice() {
        return productPrice.get();
    }

    public DoubleProperty productPriceProperty() {
        return productPrice;
    }

    public int getQuantity() {
        return quantity.get();
    }

    public IntegerProperty quantityProperty() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity.set(quantity);
        updateTotal();
    }

    public double getTotal() {
        return totalPrice.get();
    }

    public DoubleProperty productTotalProperty() {
        return totalPrice;
    }

    public void updateTotal() {
        this.totalPrice.set(this.quantity.get() * this.productPrice.get());
    }

    public HBox getQuantityControl() {
        return quantityControl;
    }
}
