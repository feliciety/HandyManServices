package project.demo.models;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Cart {
    private final ObservableList<Product> products = FXCollections.observableArrayList();

    private static Cart instance;

    private Cart() {}

    public static Cart getInstance() {
        if (instance == null) {
            instance = new Cart();
        }
        return instance;
    }

    public ObservableList<Product> getProducts() {
        return products;
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public void clear() {
        products.clear();
    }
}
