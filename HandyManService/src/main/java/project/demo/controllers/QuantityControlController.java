package project.demo.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class QuantityControlController {

    @FXML
    private Button decreaseButton;

    @FXML
    private Button increaseButton;

    @FXML
    private Label quantityLabel;

    private int quantity = 1;
    private QuantityChangeListener quantityChangeListener;

    @FXML
    public void initialize() {
        updateLabel();
    }

    @FXML
    private void decreaseQuantity() {
        if (quantity > 1) {
            quantity--;
            updateLabel();
            if (quantityChangeListener != null) {
                quantityChangeListener.onQuantityChanged(quantity);
            }
        }
    }

    @FXML
    private void increaseQuantity() {
        quantity++;
        updateLabel();
        if (quantityChangeListener != null) {
            quantityChangeListener.onQuantityChanged(quantity);
        }
    }

    private void updateLabel() {
        quantityLabel.setText(String.valueOf(quantity));
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
        updateLabel();
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantityChangeListener(QuantityChangeListener listener) {
        this.quantityChangeListener = listener;
    }

    public interface QuantityChangeListener {
        void onQuantityChanged(int newQuantity);
    }
}
