package project.demo.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class CartController {

    @FXML
    private AnchorPane anchorPane;

    @FXML
    private Button catalogButton;

    @FXML
    private Button checkoutButton;

    @FXML
    private TableView<?> cartTable;

    @FXML
    private TableColumn<?, ?> productNameColumn;

    @FXML
    private TableColumn<?, ?> productPriceColumn;

    @FXML
    private TableColumn<?, ?> productQuantityColumn;

    @FXML
    private TableColumn<?, ?> productTotalColumn;

    @FXML
    private Label subtotalLabel;

    /**
     * Initialize method to dynamically add a stylesheet if needed.
     */
    @FXML
    public void initialize() {
        // Dynamically add the stylesheet
        if (anchorPane.getScene() != null) {
            anchorPane.getScene().getStylesheets().add(getClass().getResource("/project/demo/CSS/styles.css").toExternalForm());
        } else {
            anchorPane.sceneProperty().addListener((observable, oldScene, newScene) -> {
                if (newScene != null) {
                    newScene.getStylesheets().add(getClass().getResource("/project/demo/CSS/styles.css").toExternalForm());
                }
            });
        }
    }

    /**
     * Method to handle navigation to the product catalog.
     * @param actionEvent the ActionEvent triggered by the button
     */
    @FXML
    public void goToCatalog(ActionEvent actionEvent) {
        try {
            // Get the current stage
            Stage stage = (Stage) catalogButton.getScene().getWindow();

            // Load the ProductCatalog.fxml
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/project/demo/fxml/ProductCatalog.fxml"));
            Scene scene = new Scene(loader.load(), 1440, 730);

            // Set the scene to the stage
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Method to handle navigation to the checkout page.
     * @param actionEvent the ActionEvent triggered by the button
     */
    @FXML
    public void proceedToCheckout(ActionEvent actionEvent) {
        try {
            // Get the current stage
            Stage stage = (Stage) checkoutButton.getScene().getWindow();

            // Load the CheckoutPage.fxml
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/project/demo/fxml/CheckoutPage.fxml"));
            Scene scene = new Scene(loader.load(), 1440, 730);

            // Set the scene to the stage
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
