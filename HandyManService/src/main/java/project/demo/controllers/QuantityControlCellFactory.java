package project.demo.controllers;

import javafx.fxml.FXMLLoader;
import javafx.scene.control.TableCell;
import javafx.scene.layout.HBox;
import project.demo.models.CartItem;

import java.io.IOException;

public class QuantityControlCellFactory extends TableCell<CartItem, HBox> {

    @Override
    protected void updateItem(HBox quantityControl, boolean empty) {
        super.updateItem(quantityControl, empty);

        if (empty || getTableRow() == null || getTableRow().getItem() == null) {
            setGraphic(null);
        } else {
            try {
                // Load QuantityControl FXML
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/project/demo/fxml/QuantityControl.fxml"));
                HBox quantityBox = loader.load();

                // Set up controller
                QuantityControlController controller = loader.getController();
                CartItem cartItem = getTableRow().getItem();

                if (cartItem != null) {
                    controller.setQuantity(cartItem.getQuantity());
                    controller.setQuantityChangeListener(newQuantity -> {
                        cartItem.setQuantity(newQuantity);
                        cartItem.updateTotal();

                        // Refresh table to show updated values
                        getTableView().refresh();
                    });
                }

                setGraphic(quantityBox);
            } catch (IOException e) {
                e.printStackTrace();
                setGraphic(null);
            }
        }
    }
}
