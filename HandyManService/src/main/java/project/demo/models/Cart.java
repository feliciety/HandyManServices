package project.demo.models;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Cart {

    private final ObservableList<CartItem> cartItems;

    private static final Cart instance = new Cart();

    private Cart() {
        cartItems = FXCollections.observableArrayList();
    }

    public static Cart getInstance() {
        return instance;
    }

    public ObservableList<CartItem> getCartItems() {
        return cartItems;
    }

    public void addProduct(Product product, int quantity) {
        CartItem existingItem = cartItems.stream()
                .filter(item -> item.getProductName().equals(product.getName()))
                .findFirst()
                .orElse(null);

        if (existingItem != null) {
            existingItem.setQuantity(existingItem.getQuantity() + quantity);
            existingItem.updateTotal();
        } else {
            cartItems.add(new CartItem(
                    product.getName(),
                    product.getPrice(),
                    quantity,
                    product.getPrice() * quantity,
                    null // You can later set a quantity control HBox
            ));
        }
    }
}
