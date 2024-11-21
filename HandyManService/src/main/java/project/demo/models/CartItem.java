package project.demo.models;

import javafx.beans.property.*;
import javafx.scene.layout.HBox;

public class CartItem {
    private final StringProperty productName;
    private final DoubleProperty productPrice;
    private final IntegerProperty productQuantity;
    private final DoubleProperty productTotal;
    private final ObjectProperty<HBox> quantityControl;

    public CartItem(String productName, double productPrice, int quantity, double total, HBox quantityControl) {
        this.productName = new SimpleStringProperty(productName);
        this.productPrice = new SimpleDoubleProperty(productPrice);
        this.productQuantity = new SimpleIntegerProperty(quantity);
        this.productTotal = new SimpleDoubleProperty(total);
        this.quantityControl = new SimpleObjectProperty<>(quantityControl);
    }

    public StringProperty productNameProperty() {
        return productName;
    }

    public DoubleProperty productPriceProperty() {
        return productPrice;
    }

    public IntegerProperty productQuantityProperty() {
        return productQuantity;
    }

    public DoubleProperty productTotalProperty() {
        return productTotal;
    }

    public ObjectProperty<HBox> quantityControlProperty() {
        return quantityControl;
    }

    public String getProductName() {
        return productName.get();
    }

    public double getProductPrice() {
        return productPrice.get();
    }

    public int getQuantity() {
        return productQuantity.get();
    }

    public double getTotal() {
        return productTotal.get();
    }

    public HBox getQuantityControl() {
        return quantityControl.get();
    }

    public void setQuantity(int quantity) {
        productQuantity.set(quantity);
        updateTotal();
    }

    public void setTotal(double total) {
        productTotal.set(total);
    }

    public void setQuantityControl(HBox quantityControl) {
        this.quantityControl.set(quantityControl);
    }

    public void updateTotal() {
        setTotal(getProductPrice() * getQuantity());
    }
}
