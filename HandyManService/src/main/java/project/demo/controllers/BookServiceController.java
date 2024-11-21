package project.demo.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import project.demo.models.Employee;

public class BookServiceController {

    @FXML
    private ComboBox<String> serviceFilterComboBox;

    @FXML
    private VBox serviceCardContainer;

    @FXML
    private TableView<Employee> employeeTable;

    @FXML
    private TableColumn<Employee, ImageView> employeeImageColumn;

    @FXML
    private TableColumn<Employee, String> employeeNameColumn;

    @FXML
    private TableColumn<Employee, String> employeeServiceColumn;

    @FXML
    private TableColumn<Employee, String> employeeAvailabilityColumn;

    @FXML
    private void initialize() {
        setupTableColumns();
        setupServiceFilter();
        loadAllEmployees();
    }

    private void setupTableColumns() {
        employeeImageColumn.setCellValueFactory(new PropertyValueFactory<>("image"));
        employeeNameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        employeeServiceColumn.setCellValueFactory(new PropertyValueFactory<>("service"));
        employeeAvailabilityColumn.setCellValueFactory(new PropertyValueFactory<>("availability"));
    }

    private void loadAllEmployees() {
        ObservableList<Employee> employees = FXCollections.observableArrayList(
                createEmployee("/project/demo/images/Employee2.png", "John Doe", "Plumbing", "Available"),
                createEmployee("/project/demo/images/Employee1.png", "Jane Smith", "Carpentry", "Available"),
                createEmployee("/project/demo/images/Employee6.png", "Tom Brown", "Painting", "Available")
        );

        employeeTable.setItems(employees);
        loadCards(employees);
    }

    private void setupServiceFilter() {
        serviceFilterComboBox.setItems(FXCollections.observableArrayList("All Employees", "Plumbing", "Carpentry", "Painting"));
        serviceFilterComboBox.setValue("All Employees");

        serviceFilterComboBox.setOnAction(event -> {
            String selectedService = serviceFilterComboBox.getValue();
            filterEmployeesByService(selectedService);
        });
    }

    private void filterEmployeesByService(String service) {
        ObservableList<Employee> employees = FXCollections.observableArrayList(
                createEmployee("/project/demo/images/Employee2.png", "John Doe", "Plumbing", "Available"),
                createEmployee("/project/demo/images/Employee1.png", "Jane Smith", "Carpentry", "Available"),
                createEmployee("/project/demo/images/Employee6.png", "Tom Brown", "Painting", "Available")
        );

        if (!"All Employees".equals(service)) {
            employees.removeIf(employee -> !employee.getService().equals(service));
        }

        employeeTable.setItems(employees);
        loadCards(employees);
    }

    private void loadCards(ObservableList<Employee> employees) {
        serviceCardContainer.getChildren().clear();
        for (Employee employee : employees) {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/project/demo/fxml/EmployeeCard.fxml"));
                Node card = loader.load();
                EmployeeCardController controller = loader.getController();
                controller.setEmployeeData(employee.getImage(), employee.getName(), employee.getService(), employee.getAvailability());
                serviceCardContainer.getChildren().add(card);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private Employee createEmployee(String imagePath, String name, String service, String availability) {
        ImageView imageView = new ImageView(new Image(getClass().getResource(imagePath).toExternalForm()));
        imageView.setFitWidth(50);
        imageView.setFitHeight(50);
        imageView.setPreserveRatio(true);
        return new Employee(imageView, name, service, availability);
    }
}
