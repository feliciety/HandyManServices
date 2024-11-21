package project.demo.models;

import javafx.scene.image.ImageView;

public class Employee {
    private ImageView image;
    private String name;
    private String service;
    private String availability;

    public Employee(ImageView image, String name, String service, String availability) {
        this.image = image;
        this.name = name;
        this.service = service;
        this.availability = availability;
    }

    public ImageView getImage() {
        return image;
    }

    public void setImage(ImageView image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public String getAvailability() {
        return availability;
    }

    public void setAvailability(String availability) {
        this.availability = availability;
    }
}
