package project.demo.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public  class SignUpController {

    // FXML components referenced in the FXML file
    @FXML
    private TextField usernameField;

    @FXML
    private TextField emailField;

    @FXML
    private TextField passwordField;

    @FXML
    private Button signUpButton;

    @FXML
    private Button signInOption; // Button to navigate to the Sign Up page

    // Event handler for the Sign In button
    @FXML
    private void signUpButtonClicked() {
        // Get the text entered in the fields
        String username = usernameField.getText();
        String email = emailField.getText();
        String password = passwordField.getText();

        // Validate the input fields
        if (username.isEmpty() || email.isEmpty() || password.isEmpty()) {
            System.out.println("All fields are required!");
            // Ideally, display a warning message in the UI (e.g., a label or alert dialog)
        } else if (!email.contains("@") || !email.contains(".")) {
            System.out.println("Invalid email format.");
            // Show error for invalid email format
        } else if (password.length() < 6) {
            System.out.println("Password must be at least 6 characters long.");
            // Show error for weak password
        } else {
            // All inputs are valid
            System.out.println("Sign Up successful with username: " + username + ", email: " + email);

            // Load the MainpageStructure.fxml
            loadHomePage();
        }
    }



    // Dummy authentication method (replace with real implementation)
    private boolean authenticateUser(String email, String password) {
        // Replace this with actual authentication logic (e.g., database query)
        return "admin@gmail.com".equals(email) && "123".equals(password);
    }

    // Load the MainpageStructure.fxml after successful sign-in
    private void loadHomePage() {
        try {
            // Load MainpageStructure.fxml
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/project/demo/FXML/MainpageStructure.fxml"));
            AnchorPane homePageRoot = loader.load();

            // Get the current stage
            Stage stage = (Stage) signUpButton.getScene().getWindow();

            // Create a new scene and set it to the stage
            Scene homePageScene = new Scene(homePageRoot);
            stage.setScene(homePageScene);
            stage.show();

            System.out.println("Navigated to Home Page.");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error loading Home Page.");
        }
    }


    // Event handler for the Sign Up button
    @FXML
    private void signInSwap() {
        try {
            // Load SignUp.fxml
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/project/demo/FXML/SignIn.fxml"));
            AnchorPane signUpRoot = loader.load();

            // Create a new scene for the SignUp page
            Scene signUpScene = new Scene(signUpRoot);
            Stage stage = (Stage) signInOption.getScene().getWindow();

            // Set the new scene
            stage.setScene(signUpScene);
            stage.show(); // Show the new scene
            System.out.println("Navigated to Sign Up page.");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error loading Sign Up page.");
        }
    }
}
