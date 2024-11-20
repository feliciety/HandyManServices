package project.demo.models;

import javafx.beans.property.*;

public class Product {
    private final StringProperty name;
    private final DoubleProperty price;
    private final StringProperty imagePath;

    public Product(String name, double price, String imagePath) {
        this.name = new SimpleStringProperty(name);
        this.price = new SimpleDoubleProperty(price);
        this.imagePath = new SimpleStringProperty(imagePath);
    }

    // Getters and setters
    public String getName() { return name.get(); }
    public StringProperty nameProperty() { return name; }

    public double getPrice() { return price.get(); }
    public DoubleProperty priceProperty() { return price; }

    public String getImagePath() { return imagePath.get(); }
    public StringProperty imagePathProperty() { return imagePath; }
}
