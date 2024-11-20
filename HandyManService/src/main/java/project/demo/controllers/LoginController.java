package project.demo.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.stage.Stage;

public class LoginController {

    @FXML
    private Button loginButton;

    @FXML
    private Button registerButton;

    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private void handleLoginButton() {
        // Simulate user validation (replace with actual authentication logic)
        String username = usernameField.getText();
        String password = passwordField.getText();

        if (!username.isEmpty() && !password.isEmpty()) {
            System.out.println("Login successful for user: " + username);
            loadScene("/project/demo/fxml/ProductCatalog.fxml");
        } else {
            System.out.println("Invalid username or password!");
        }
    }

    @FXML
    private void handleRegisterButton() {
        // Redirect to the registration screen (add your registration logic here)
        System.out.println("Navigating to registration screen...");
        loadScene("/project/demo/fxml/RegisterPage.fxml");
    }

    /**
     * Logic for the "Login" button click.
     */
    public void loginclicked(ActionEvent actionEvent) {
        System.out.println("Login button clicked.");
        handleLoginButton();
    }

    /**
     * Logic for the "Register" button click.
     */
    public void registerclicked(ActionEvent actionEvent) {
        System.out.println("Register button clicked.");
        handleRegisterButton();
    }

    /**
     * Reusable method to load and display a new scene.
     *
     * @param fxmlPath The path to the FXML file to be loaded
     */
    private void loadScene(String fxmlPath) {
        try {
            Stage stage = (Stage) loginButton.getScene().getWindow(); // Reuse the current stage
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlPath));
            Scene scene = new Scene(loader.load(), 1440, 730);
            stage.setScene(scene);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
