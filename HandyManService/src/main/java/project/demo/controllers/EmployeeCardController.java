package project.demo.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

public class EmployeeCardController {

    @FXML
    private ImageView employeeImage;

    @FXML
    private Label employeeName;

    @FXML
    private Label employeeService;

    @FXML
    private Label employeeAvailability;

    public void setEmployeeData(ImageView image, String name, String service, String availability) {
        employeeImage.setImage(image.getImage());
        employeeName.setText(name);
        employeeService.setText(service);
        employeeAvailability.setText(availability);
    }
}
