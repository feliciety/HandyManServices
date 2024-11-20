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
        String username = usernameField.getText();
        String email = emailField.getText();
        String password = passwordField.getText();

        if (username.isEmpty() || email.isEmpty() || password.isEmpty()) {
            System.out.println("All fields are required!");
        } else {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/project/demo/fxml/MainpageStructure.fxml"));
                AnchorPane mainPage = loader.load();
                Stage stage = (Stage) signUpButton.getScene().getWindow();
                stage.setScene(new Scene(mainPage));
                stage.show();
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("Error navigating to MainpageStructure.fxml.");
            }
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
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/project/demo/fxml/MainpageStructure.fxml"));
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
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/project/demo/fxml/SignIn.fxml"));
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
