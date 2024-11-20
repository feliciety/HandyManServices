package project.demo.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class SignInController {

    // FXML components referenced in the FXML file
    @FXML
    private TextField emailField;

    @FXML
    private TextField passwordField;

    @FXML
    private Button SignInButton;

    @FXML
    private Button signUpOption; // Corrected to match the FXML


    // Initialize method (optional but useful for setup logic)
    @FXML
    public void initialize() {
        signUpOption.setText("Sign Up"); // Corrected this line
    }

    // Event handler for the Sign In button
    @FXML
    private void SignInButtonClicked() {
        String email = emailField.getText();
        String password = passwordField.getText();

        if (email.isEmpty() || password.isEmpty()) {
            System.out.println("Please fill out all fields.");
            // Ideally, show a dialog or label to inform the user
        } else {
            // Replace this with actual authentication logic
            System.out.println("Attempting to sign in with email: " + email);
            boolean isAuthenticated = authenticateUser(email, password);

            if (isAuthenticated) {
                System.out.println("Sign in successful!");
                // Navigate to the HomePage after successful sign in
                loadHomePage();
            } else {
                System.out.println("Invalid email or password.");
                // Show an error message in the UI (e.g., a label or alert)
            }
        }
    }

    // Dummy authentication method (replace with real implementation)
    private boolean authenticateUser(String email, String password) {
        // For example, compare with hardcoded values or query a database
        return "admin@gmail.com".equals(email) && "123".equals(password);
    }

    // Load the MainpageStructure.fxml after successful sign-in
    private void loadHomePage() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/project/demo/fxml/MainpageStructure.fxml"));
            AnchorPane homePageRoot = loader.load(); // Load the HomePage FXML

            // Create a new scene for the HomePage
            Scene homePageScene = new Scene(homePageRoot);

            // Get the current stage (window) and set the new scene
            Stage stage = (Stage) SignInButton.getScene().getWindow(); // Get the stage of the current scene
            stage.setScene(homePageScene); // Set the new scene
            stage.show(); // Show the new scene
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error loading MainpageStructure.fxml.");
        }
    }

    // Event handler for the Sign Up button
    @FXML
    private void signUpSwap() {
        try {
            // Load SignUpPage FXML
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/project/demo/fxml/SignUp.fxml"));
            AnchorPane signUpRoot = loader.load();

            // Create a new scene for the SignUpPage
            Scene signUpScene = new Scene(signUpRoot);
            Stage stage = (Stage) signUpOption.getScene().getWindow(); // Use signUpOption here

            // Set the new scene
            stage.setScene(signUpScene);
            stage.show(); // Show the new scene
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error loading Sign Up page.");
        }
    }
}