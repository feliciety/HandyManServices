package project.demo.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;

import java.io.IOException;

public class LoginController {

    @FXML
    private Button loginButton;

    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private TextField showPasswordField;

    @FXML
    private CheckBox showPasswordCheckbox;

    /**
     * Handle login button click to validate credentials and navigate to ProductCatalog.
     */
    @FXML
    private void handleLoginButton() {
        String username = usernameField.getText();
        String password = passwordField.isVisible() ? passwordField.getText() : showPasswordField.getText();

        // Validation
        if (username.isEmpty() || password.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Username or Password cannot be empty!", ButtonType.OK);
            alert.showAndWait();
            return;
        }

        // Authentication logic (dummy example)
        if (username.equals("admin") && password.equals("password")) {
            try {
                // Navigate to ProductCatalog
                Stage stage = (Stage) loginButton.getScene().getWindow();
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/project/demo/fxml/ProductCatalog.fxml"));
                Scene scene = new Scene(loader.load(), 1440, 730);
                stage.setScene(scene);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Invalid Username or Password!", ButtonType.OK);
            alert.showAndWait();
        }
    }

    /**
     * Toggle the visibility of the password field.
     */
    @FXML
    public void togglePasswordVisibility(ActionEvent actionEvent) {
        if (showPasswordCheckbox.isSelected()) {
            showPasswordField.setText(passwordField.getText());
            showPasswordField.setVisible(true);
            passwordField.setVisible(false);
        } else {
            passwordField.setText(showPasswordField.getText());
            passwordField.setVisible(true);
            showPasswordField.setVisible(false);
        }
    }

    public void loginclicked(ActionEvent actionEvent) {
        System.out.println("Login button clicked.");

        try {
            // Load the ProductCatalog.fxml file
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/project/demo/fxml/ProductCatalog.fxml"));
            Parent root = loader.load();

            // Get the current stage and set the new scene
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Product Catalog");
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Failed to load ProductCatalog.fxml.");
        }
    }

    /**
     * Placeholder for register button clicked.
     */
    public void registerclicked(ActionEvent actionEvent) {
        System.out.println("Register button clicked.");

        // Perform registration logic
        boolean isNewUser = true; // Replace this with actual registration logic
        if (isNewUser) {
            System.out.println("New user registered successfully.");
            loginclicked(actionEvent); // Redirect to ProductCatalog.fxml after registration
        } else {
            System.err.println("User already exists. Please try a different username.");
        }
    }
}
