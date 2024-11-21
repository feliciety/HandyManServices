package project.demo.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class QuantityControlController {

    @FXML
    private Button increaseButton;

    @FXML
    private Button decreaseButton;

    @FXML
    private Label quantityLabel;

    private int quantity;
    private QuantityChangeListener listener;

    @FXML
    public void initialize() {
        updateLabel();
    }

    @FXML
    private void increaseQuantity() {
        setQuantity(quantity + 1);
    }

    @FXML
    private void decreaseQuantity() {
        if (quantity > 1) {
            setQuantity(quantity - 1);
        }
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
        updateLabel();
        if (listener != null) {
            listener.onQuantityChanged(quantity);
        }
    }

    public void setQuantityChangeListener(QuantityChangeListener listener) {
        this.listener = listener;
    }

    private void updateLabel() {
        quantityLabel.setText(String.valueOf(quantity));
    }

    public interface QuantityChangeListener {
        void onQuantityChanged(int newQuantity);
    }
}
